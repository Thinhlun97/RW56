package vti.backend;

public class Department {
    public int id;
    public String name;
    public int departmentId;
    public String departmentname;

    public Department(){
        id = 0;
        name = "default - name";
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void showInfo(){
        System.out.println("thông tin của phòng ban này là: ");
        System.out.println("id :" + id);
        System.out.println("name :" + name);
    }
}
