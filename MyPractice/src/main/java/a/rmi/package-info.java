/**
 * Описание работы
 * Распределенная объектная модель, специфицирующая, каким образом производится вызов удалённых методов,
 * работающих на другой виртуальной машине Java.
 *
 * При доступе к объекту на другом компьютере возможно вызывать методы этого объекта.
 * Необходимо только передать параметры метода на другой компьютер, сообщить объекту о необходимости выполнения метода,
 * а затем получить обратно возвращаемое значение. Механизм RMI даёт возможность организовать выполнение всех этих операций.
 *
 *
 * Типичная реализация модели Java-RMI, использующая объекты 'заглушки'(stub) и 'скелета'(skeleton).
 * В терминах RMI объект, который вызывает удалённый метод, называется клиентским объектом,
 * а удалённый объект — серверным объектом. Компьютеры выступают в роли клиента и сервера только для конкретного вызова.
 * Вполне возможно, что при выполнении следующей операции эти компьютеры поменяются ролями,
 * то есть сервер предыдущего вызова может сам стать клиентом при обращении к объекту на другом компьютере.
 *
 * При вызове метода удалённого объекта на самом деле вызывается обычный метод языка Java,
 * инкапсулированный в специальном объекте-заглушке (stub), который является представителем серверного объекта.
 * Заглушка находится на клиентском компьютере, а не на сервере. Она упаковывает параметры удалённого метода в блок байтов.
 * Каждый параметр кодируется с помощью алгоритма, обеспечивающего независимость от аппаратуры.
 * Например, числа всегда передаются в порядке, при котором сначала передаётся старший байт (big-endian).
 * При этом объекты подвергаются сериализации. Процесс кодирования параметров называется развертыванием параметров
 * (parameter marshaling). Основная цель развёртывания параметров — преобразование их в формат,
 * пригодный для передачи параметров от одной виртуальной машины к другой.
 *
 * Метод, принадлежащий заглушке, создаёт блок, в который входят следующие элементы:
 * идентификатор удалённого объекта;
 * описание вызываемого метода;
 * развёрнутые параметры.
 *
 * Затем метод заглушки посылает эту информацию серверу. Далее объект-получатель, скелет (skeleton),
 * выполняет для каждого вызова удалённого метода следующие действия:
 * свёртывание параметров;
 * поиск вызванного объекта;
 * вызов заданного метода;
 * извлечение и развёртывание возвращаемого значения или исключения, сгенерированного данным методом;
 * передача пакета, состоящего из развёрнутых возвращаемых данных, объекту-заглушке на клиентском компьютере.
 *
 * Клиентский объект-заглушка свертывает возвращаемое значение или исключение, полученное с сервера.
 * Результат свёртывания становится возвращаемым значением метода заглушки.
 * Если удалённый метод возвращает исключение, то объект-заглушка повторит его в среде объекта-клиента.
 *
 * Для вызова удалённого метода используется тот же синтаксис, что и для обращения к локальному методу.
 * Например, чтобы вызвать метод getQuantity() объекта-заглушки central Warehouse центрального хранилища данных
 * на удалённом компьютере, потребуется использовать приведённый ниже код.
 *
 *   int q=centralWarehouse.getQuantity("SuperSucker 100 Vacuum Cleaner");
 *
 *
 * Для доступа к удалённым методам клиентский код всегда использует объектные переменные типа interface.
 * Например, с приведённым выше методом может быть связан следующий интерфейс:
 * interface Warehouse {
 *         int getQuantity(String description) throws RemoteException;
 *         Product getProduct(Customer cust) throws RemoteException;
 *         // ...
 * }
 * Объявление переменной для объекта, который реализует этот интерфейс, будет выглядеть так:
 *          Warehouse centralWarehouse = // ...;
 *
 *
 * Конечно, интерфейсы представляют собой абстракции и содержат только перечень методов.
 * Переменные типа interface всегда должны быть связаны с фактическим объектом.
 * При вызове удалённых объектов переменная ссылается на объект-заглушку.
 * При этом клиентская программа ничего не знает о типе заглушки, а сами заглушки и связанные с ними объекты создаются
 * автоматически.
 *
 * При передаче объекта другой программе (он может быть параметром либо возвращаемым значением удалённого метода)
 * нужен файл класса, соответствующий этому объекту. Например, метод, который возвращает значение типа Product.
 * При компиляции клиентской программы должен быть сгенерирован файл класса Product.class.
 *
 * При загрузке фрагментов кода по сети всегда возникают сомнения по поводу должного обеспечения безопасности.
 * В связи с этим в приложениях с использованием RMI применяется диспетчер защиты.
 * Он защищает заглушки от проникновения в них вирусов.
 *
 *
 *
 *
 *
 * Перед запуском этого приложения, необходимо создать файл 'Заглушки'(Stub) для используемого интерфейса.
 * Для этого можно воспользоваться RMI компилятором - 'rmic'
 *
 * Внимание: заглушка создаётся из *.class файла содержащего реализацию удалённого интерфейса,
 * а не из '*.java' файла* (Начиная с java 1.5+ создавать заглушку stub с помощью rmic не требуется)
 * rmic RmiServer
 *
 *
 * Файл server.policy — необходим для предоставлению серверу права TCP/IP соединения к удалённому регистру и RMI серверу.
 * Файл server.policy используется с помощью аргумента '-D' в Java RTE :
 * java.exe -Djava.security.policy=server.policy RmiServer
 *
 * Файл client.policy—необходим для того, чтобы клиент смог присоединиться к серверу RMI по TCP/IP.
 *
 * Файл no.policy— рекомендуется использовать для клиента либо сервера при возникновения проблем с соединением.
 */
package a.rmi;