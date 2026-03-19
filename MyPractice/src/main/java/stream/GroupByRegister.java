package stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GroupByRegister {

    enum Section {OPER, INSTR, TRANS, ORDER}


    static class Entity {
        String name;
        Section section;
        String registerId;
        String transactionId;
        String instructionId;

        public Entity(String name, Section section, String registerId, String transactionId, String instructionId) {
            this.name = name;
            this.section = section;
            this.registerId = registerId;
            this.transactionId = transactionId;
            this.instructionId = instructionId;
        }

        public String getName() {
            return name;
        }

        public Section getSection() {
            return section;
        }

        public String getRegisterId() {
            return registerId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getInstructionId() {
            return instructionId;
        }

        @Override
        public String toString() {
            return "{" + name + ", " + section + ", " + registerId + ", " + transactionId + ", " + instructionId + "}";
        }
    }


    private static List<Entity> entities = new ArrayList<>();

    static {
        entities.add(new Entity("oper11", Section.OPER, "r1", "t1", null));
        entities.add(new Entity("oper12", Section.OPER, "r1", "t1", null));
        entities.add(new Entity("trans1", Section.TRANS, null, "t1", "i1"));
        entities.add(new Entity("instr1", Section.INSTR, null, "i1", "i1"));

        entities.add(new Entity("oper21", Section.OPER, "r2", "t2", null));
        entities.add(new Entity("oper22", Section.OPER, "r2", "t2", null));
        entities.add(new Entity("trans2", Section.TRANS, null, "t2", "i2"));
        entities.add(new Entity("instr2", Section.INSTR, null, "i2", "i2"));
    }

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Set<String>> registerIdsByTransId = entities.stream()
                .filter(e -> e.registerId != null)
                .collect(Collectors.groupingBy(
                        e -> e.transactionId,
                        Collectors.mapping(e -> e.registerId, Collectors.toSet())
                ));

        Map<String, Set<String>> instrIdsByTransId = entities.stream()
                .filter(e -> e.instructionId != null)
                .filter(e -> registerIdsByTransId.containsKey(e.transactionId))
                .collect(Collectors.groupingBy(
                        e -> e.transactionId,
                        Collectors.mapping(e -> e.instructionId, Collectors.toSet())
                ));

        Map<String, Set<Entity>> groupedByRegister = entities.stream()
                .peek(e -> { // set transactionId for INSTR
                    if (e.instructionId != null && e.instructionId.equals(e.transactionId)) {
                        instrIdsByTransId.entrySet().stream()
                                .filter(es -> es.getValue().contains(e.instructionId))
                                .map(Map.Entry::getKey)
                                .findAny()
                                .ifPresent(i -> e.transactionId = i);
                    }
                })
                .flatMap(e -> registerIdsByTransId.containsKey(e.transactionId) ?
                        registerIdsByTransId
                                .get(e.transactionId)
                                .stream()
                                .map(r -> Map.entry(r, e))
                        : Stream.empty()
                )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));

        System.out.println(
                new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(groupedByRegister)
        );
    }

}
