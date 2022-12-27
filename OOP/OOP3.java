package OOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OOP3 {

    public static void main(String[] args) {
        Worker wk = new Worker(30, 25000, "Oleg");
        Button bt = new Button();
        bt.click(wk);
    }
}


class Worker {
    int age;
    int salary;
    String name;

    public Worker() {
    }

    public Worker(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }
}


interface Save {
    void print(Worker someWorker);
}

class XmlForm implements Save {
    @Override
    public void print(Worker someWorker) {
        System.out.print("<xml>\n<Worker>\n");
        System.out.printf("<age>%d</age>\n<salary>%d</salary>\n<name>%s</name>\n",
                someWorker.age, someWorker.salary, someWorker.name);
        System.out.print("</Worker>\n</xml>");
    }

}

class MdForm implements Save{
    @Override
    public void print(Worker someWorker) {
        System.out.println("# Worker");
        System.out.printf("* age %d\n* salary %d\n* name %s\n ",
                someWorker.age, someWorker.salary, someWorker.name);

    }

}

class JsonForm implements Save {
    @Override
    public void print(Worker someWorker) {
        System.out.print("{\n 'worker' : {\n ");
        System.out.printf("'age':%d\n 'salary':%d\n 'name':%s\n",
                someWorker.age, someWorker.salary, someWorker.name);
        System.out.print("}\n}");
    }

}


class Button {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
    public void click(Worker someWorker) {
        int select;
        while (true) {
            try {
                System.out.println("Введите 1 для xml, 2  md, 3 json. ");
                select = Integer.parseInt(br.readLine());
                if (select == 0 | select > 3) {
                    System.out.println("Error");
                } else {
                    break;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Error");
            }
        }
        switch (select) {
            case 1:
                XmlForm xml = new XmlForm();
                xml.print(someWorker);
                break;
            case 2:
                MdForm md = new MdForm();
                md.print(someWorker);
                break;
            case 3:
                JsonForm js = new JsonForm();
                js.print(someWorker);
                break;
        }
    }
}