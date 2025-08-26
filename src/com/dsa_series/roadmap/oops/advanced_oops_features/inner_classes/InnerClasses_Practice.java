package com.dsa_series.roadmap.oops.advanced_oops_features.inner_classes;

// Your code goes here

class Robot {
    private String name;

    Robot(String name) {
        this.name = name;
    }

    public void performAction() {
        System.out.println(name + " is performing an action.");
    }

    public void manageSensors() {
        class Sensor {
            public void sense() {
                System.out.println(name + " sensor detecting obstacles.");
            }
        }

        Sensor sensor = new Sensor();
        sensor.sense();
    }

    class Arm {
        public void pickItem() {
            System.out.println(name + " arm picking an item.");
        }
    }

    static class Processor {
        public void process() {
            System.out.println("Processor analyzing the data.");
        }
    }

    public void executeTask() {
        Task task = new Task() {

            @Override
            public void execute() {
                System.out.println(name + " executing a custom task.");
            }
        };
        task.execute();
    }

    interface Task {
        public void execute();
    }
}

// Please Do not change anything below, It is only for your reference.
/*
 * 
 * //Below code demonstates the Driver code and its working for the class
 * 'Robot'.
 * 
 * 
 * public static void main(String[] args) {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * String name;
 * 
 * //Creating the object of the class Robot
 * Robot robot = new Robot(name);
 * 
 * //Calling the performAction method of class Robot
 * robot.performAction();
 * 
 * //Using non static inner class
 * //creating the object of the inner class and calling the its method pickItem
 * Robot.Arm arm = robot.new Arm();
 * arm.pickItem();
 * 
 * //Using static nested class
 * //creating the object of the nested class and calling the its method process
 * Robot.Processor processor = new Robot.Processor();
 * processor.process();
 * 
 * //Calling the method manageSensors that implements the local inner class
 * //It then calls the sense method inside the manageSensors method to print the
 * coorresponding text
 * robot.manageSensors();
 * 
 * //Calling method executeTask that Override the method execute which is
 * implemented in by the interface Task
 * robot.executeTask();
 * }
 * }
 * 
 */

/*
 * 
 * System.out.println(name + " is performing an action."); -> It is for
 * performAction method
 * System.out.println(name + " arm picking an item."); -> It is for pickItem
 * method
 * System.out.println("Processor analyzing the data."); -> It is for process
 * method
 * System.out.println(name + " sensor detecting obstacles."); -> It is for sense
 * method
 * System.out.println(name + " executing a custom task."); -> It is for execute
 * method
 * 
 */

public class InnerClasses_Practice {

}
