package fi.sdacademy.janoka.patterns.interpreter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterpreterExample {

    interface Expression {
        List<String> interpret(Context ctx);
    }

    class Select implements Expression {

        private String column;
        private From from;

        Select(String column, From from) {
            this.column = column;
            this.from = from;
        }

        @Override
        public List<String> interpret(Context ctx) {
            ctx.column = column;
            return from.interpret(ctx);
        }
    }

    class From implements Expression {

        private String table;
        private Where where;

        public From(String table) {
            this(table, null);
        }

        public From(String table, Where where) {
            this.table = table;
            this.where = where;
        }

        @Override
        public List<String> interpret(Context ctx) {
            ctx.table = table;
            if (where == null) {
                return ctx.search();
            }
            return where.interpret(ctx);
        }
    }

    class Where implements Expression {

        private Predicate<String> filter;

        // constructor

        @Override
        public List<String> interpret(Context ctx) {
            ctx.whereFilter = filter;
            return ctx.search();
        }
    }

    static class Context {

        private static Map<String, List<Row>> tables = new HashMap<>();

        static {
            List<Row> list = new ArrayList<>();
            list.add(new Row("John", "Doe"));
            list.add(new Row("Jan", "Kowalski"));
            list.add(new Row("Dominic", "Doom"));

            tables.put("people", list);
        }

        private String table;
        private String column;
        private Predicate<String> whereFilter;

        private void clear(){
            //clear the context
        }

        List<String> search() {


            List<String> result = tables.entrySet()
                    .stream()
                    .filter(entry -> entry.getKey().equalsIgnoreCase(table))
                    .flatMap(entry -> Stream.of(entry.getValue()))
                    .flatMap(Collection::stream)
                    .map(Row::toString)
                    //.flatMap(columnMapper)
                    .filter(whereFilter)
                    .collect(Collectors.toList());

            clear();

            return result;
        }
    }

    static class Row {
        Row(String name, String surname){}
    }

    public void exampleUsage() {
        Expression query = new Select("name", new From("people"));
        Context ctx = new Context();
        List<String> result = query.interpret(ctx);
        System.out.println(result);
    }
}
