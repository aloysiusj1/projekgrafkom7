import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class LebahMike {

    private Window window = new Window(800, 800, "C14210214_Michael Chiang");
    private ArrayList<ObjectMike> objects = new ArrayList<>();
    private ArrayList<ObjectMike> objectsCircle = new ArrayList<>();
    private ArrayList<ObjectMike> objectsRectwCircle = new ArrayList<>();
    private ArrayList<Object> objectsOval = new ArrayList<>();
    private ArrayList<Object> objectsTriCircle = new ArrayList<>();
    private ArrayList<Object> objectsStar = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private ArrayList<SphereMike> objectsSphere = new ArrayList<>();
    private ArrayList<SphereMike> objectsElipsoid = new ArrayList<>();
    private ArrayList<SphereMike> objectsHyperBoloid2 = new ArrayList<>();
    private ArrayList<SphereMike> objectsHyperparaboloid = new ArrayList<>();
    private ArrayList<SphereMike> objectsElipticparaboloid = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();
        input();

        //code
        //eyes
        objectsSphere.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.0f, 0.0f, 0.01f, 0.01f, 0.1f, 64, 32, 0
        ));
        objectsSphere.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.0f, 0.0f, 0.01f, 0.01f, 0.1f, 64, 32, 0
        ));
        //wings
        objectsElipsoid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.0f, 0.0f, 0.4f, 0.5f, 0.3f, 64, 32, 3
        ));
        objectsElipsoid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.0f, 0.0f, 0.4f, 0.5f, 0.3f, 64, 32, 3
        ));
        //body
        objectsElipsoid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                0.0f, 0.0f, 0.4f, 0.5f, 0.3f, 64, 32, 3
        ));
        //sting
        objectsElipticparaboloid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.0f, 0.0f, 0.01f, 0.01f, 0.1f, 64, 32, 3
        ));

//        objectsHyperBoloid2.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                0.0f, 0.0f, 0.01f, 0.01f, 0.01f, 22, 14
//        ));

        //eyes
        objectsSphere.get(0).translateObject(0.5f, 1.4f, -1.2f);
        objectsSphere.get(0).scaleObject(0.1f, 0.1f, 0.1f);
        objectsSphere.get(1).translateObject(-0.5f, 1.4f, -1.2f);
        objectsSphere.get(1).scaleObject(0.1f, 0.1f, 0.1f);
        //body
        objectsElipsoid.get(2).translateObject(0.0f, 0.0f, 0.0f);
        objectsElipsoid.get(2).scaleObject(0.4f, 0.5f, 0.3f);
        //sting
        objectsElipticparaboloid.get(0).translateObject(0.0f, -1.2f, 0.0f);
        objectsElipticparaboloid.get(0).scaleObject(0.03f, 0.2f, 0.02f);
//      wings
        objectsElipsoid.get(1).translateObject(-0.5f, 0.0f, 10.0f);
        objectsElipsoid.get(1).scaleObject(0.38f, 0.15f, 0.01f);
        objectsElipsoid.get(0).translateObject(0.5f, 0.0f, 10.0f);
        objectsElipsoid.get(0).scaleObject(0.38f, 0.15f, 0.01f);

//        //moon
//        objectsSphere.get(4).translateObject(1.9f, 1.9f, 0.0f);
//        objectsSphere.get(4).scaleObject(0.2f, 0.2f, 0.2f);

//        objectsRectwCircle.add(new RectwCircle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),//r g b a
//                Arrays.asList(0, 1, 2, 1, 2, 3, 3, 0),
//                0.0f, 0.0f, 0.01f
//        ));

//        objectsPointsControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
//        ));

    }

    public void input(){
        //gtw
        if (window.isKeyPressed(GLFW_KEY_W)) {
            System.out.println("W");
            objectsElipsoid.get(1).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsElipsoid.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_F)) {
//            System.out.println("F");
            objectsElipticparaboloid.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipticparaboloid.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsElipsoid.get(2).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);

            objectsElipsoid.get(1).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsElipsoid.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);

            objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            objectsSphere.get(1).translateObject(0.0f, 0.0f, 0.0f);
            objectsSphere.get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
        }

//        if (window.isKeyPressed(GLFW_KEY_H)) {
////            System.out.println("H");
//            objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.0f);
//            objectsSphere.get(0).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 0.0f);
//            objectsSphere.get(1).translateObject(0.0f, 0.0f, 0.0f);
//            objectsSphere.get(1).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 0.0f);
//        }
//      salto ke blakang
        if (window.isKeyPressed(GLFW_KEY_G)) {
//            System.out.println("G");
//            objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.0f);
//            objectsSphere.get(0).rotateObject((float) Math.toRadians(1.0f), 0.8f, 0.0f, 0.0f);
            objectsElipticparaboloid.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipticparaboloid.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            objectsElipsoid.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);

            objectsElipsoid.get(1).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(1).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            objectsElipsoid.get(2).translateObject(0.0f, 0.0f, 0.0f);
            objectsElipsoid.get(2).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);

            objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.0f);
            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            objectsSphere.get(1).translateObject(0.0f, 0.0f, 0.0f);
            objectsSphere.get(1).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);

        }

//        if (window.getMouseInput().isLeftButtonPressed()) {
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//
//                System.out.println("x: " + pos.x + "y: " + pos.y);
//                int index = 0;
//                overlapped = false;
//                for (Rectangle1 object : objectsRectangle) {
//                    overlapped = object.isOverlapped(pos.x, pos.y);
//                    if (overlapped) {
//                        break;
//                    }
//
//                }
//                for (Rectangle1 object : objectsRectangle) {
//                    overlapped2 = object.isOverlappedd(pos.x, pos.y);
//                    if (overlapped2) {
//                        if (object.isOverlapped(pos.x, pos.y)) {
//                            objectsPointsControl.get(0).updateVertices(index, new Vector3f(pos.x, pos.y, 0));
//                            object.move(pos.x, pos.y, 0.1f);
//                        }
//                    }
//                    index++;
//                }
//                System.out.println(index);
//                if (!overlapped) {
//                    objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                    objectsRectangle.add(new RectwCircle(Arrays.asList(
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                    ),
//                            new ArrayList<>(),
//                            new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                            Arrays.asList(0, 1, 1, 2, 2, 3, 3, 0), pos.x, pos.y, 0.1f
//                    ));
//                }
//            }
//        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GL.createCapabilities();
            input();

            //code
            for (ObjectMike object : objects) {
                object.drawWithVerticesColor();
            }
            for (SphereMike object : objectsElipticparaboloid){
                object.draw();
            }
            for (SphereMike object : objectsElipsoid){
                object.draw();
            }
            for (SphereMike object : objectsSphere){
                object.draw();
            }
//            for (Object object : objectsHyperparaboloid){
//                object.draw();
//            }
//            for (Object object : objectsHyperBoloid2){
//                object.draw();
//            }

//            if (window.isKeyPressed(GLFW_KEY_W)) {
//                System.out.println("W");
//                objectsElipsoid.get(1).translateObject(0.0f, 0.0f, 0.0f);
//                objectsElipsoid.get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
//                objectsElipsoid.get(2).translateObject(0.0f, 0.0f, 0.0f);
//                objectsElipsoid.get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
////                if (objectsElipsoid.get(1)) {
//
////                }
//            }
            glDisableVertexAttribArray(0);

            //poll for windows events
            //the key callback above will only be invoked during this call
            glfwPollEvents();
        }

    }
    public void run () {
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main (String[]args){
        new LebahMike().run();
    }
}