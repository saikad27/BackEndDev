//Explanation: This code somewhat explains what happens Connetion interface in JDBC ,an indirect object creation of an interface.

// Step 1: Define the Shape interface
interface Shape {
    void draw();
}

// Step 2: Create classes that implement the Shape interface
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Step 3: Create a ShapeFactory to generate objects of the Shape type
class ShapeFactory {
    // Factory method to create objects of Shape type
    public static Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();  // returns a Circle instance
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();  // returns a Square instance
        }
        return null;
    }
}

// Step 4: Use the factory to get objects without knowing their concrete class
 class Main {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("CIRCLE");  // indirectly creates a Circle
        shape1.draw();  // Output: Drawing a Circle

        Shape shape2 = ShapeFactory.getShape("SQUARE");  // indirectly creates a Square
        shape2.draw();  // Output: Drawing a Square
    }
}

