package fi.sdacademy.janoka.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeExample {

    public interface Department {
        void printDepartmentName();
    }

    public class FinancialDepartment implements Department {

        private Integer id;
        private String name;

        public void printDepartmentName() {
            System.out.println(getClass().getSimpleName());
        }
    }

    public class SalesDepartment implements Department {

        private Integer id;
        private String name;

        public void printDepartmentName() {
            System.out.println(getClass().getSimpleName());
        }
    }

    public class HeadDepartment implements Department {
        private Integer id;
        private String name;

        private List<Department> childDepartments;

        public HeadDepartment(Integer id, String name) {
            this.id = id;
            this.name = name;
            this.childDepartments = new ArrayList<>();
        }

        public void printDepartmentName() {
            childDepartments.forEach(Department::printDepartmentName);
        }

        public void addDepartment(Department department) {
            childDepartments.add(department);
        }

        public void removeDepartment(Department department) {
            childDepartments.remove(department);
        }
    }
}
