import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class MainTTSRY {
    private Window window =
            new Window(800, 800, "Rumah");
    ArrayList<Sphere> TTSRY = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init() {
        window.init();
        GL.createCapabilities();
        // code dst jangan ditaruh diatas code diatas

        //Matahari
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.5f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).scaleObject(0.8f,0.8f,0.8f);
        TTSRY.get(0).translateObject(0.0f,0.0f,0.0f);

        //Merkurius
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3 ));
        TTSRY.get(1).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(1).translateObject(0.3f,0.0f,0.0f);

        //Venus
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.913f, 0.313f, 0.0549f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(2).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(2).translateObject(0.5f,0.0f,0.0f);
        //Bumi
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));

        TTSRY.get(3).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(3).translateObject(0.7f,0.0f,0.0f);
        //Mars
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.8f, 0.0f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));

        TTSRY.get(4).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(4).translateObject(0.9f,0.0f,0.0f);
        //Bulan
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30 , // Sector --> Titik
                3));

        TTSRY.get(5).scaleObject(0.175f,0.175f,0.175f);
        TTSRY.get(5).translateObject(0.7f,0.15f,0.0f);
        /*
        object3D.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f,0.5f,0.0f),
                                new Vector3f(-0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,0.5f,0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                0.1,
                new ArrayList<>(List.of(0.0f,0.0f,0.0f)),
                0.5f,
                0.5f,
                1,
                3,
                5
        ));

        objectsPointControl.add(new Object2D(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f,0.6f,0.7f,1.0f)
        ));
    }
         */
    }

    boolean cek = false;
    boolean drag = false;
    int noHold = 0;
    Circle temp;
    boolean collisionFree = true;
    double jarak;

    public void input() {

        List<ShaderProgram.ShaderModuleData> shader = Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData(
                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData(
                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
        );

        /*
        0 = Matahari
        1 = Merkurius
        2 = Venus
        3 = Bumi
        4 = Mars
        5 = Bulan
         */
        if(window.isKeyPressed(GLFW_KEY_F)){
            TTSRY.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,1.25f);
            TTSRY.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0f,0.75f);
            TTSRY.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0f,1.0f);
            TTSRY.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,0f,1.25f);
            TTSRY.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0f,1.f);

            System.out.println("F");
        }
        if(window.isKeyPressed(GLFW_KEY_G)){

            TTSRY.get(0).rotateObject((float) Math.toRadians(0.5f),1f,1f,0f);
            TTSRY.get(0).scaleObject(1f,1f,1f);

            TTSRY.get(1).translateObject(-TTSRY.get(1).getCenterPoint().get(0),0f,0f);
            TTSRY.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
            TTSRY.get(1).translateObject(TTSRY.get(1).getCenterPoint().get(0),0f,0f);

            TTSRY.get(1).scaleObject(1f,1f,1f);

            TTSRY.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(2).scaleObject(1f,1f,1f);

            TTSRY.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(3).scaleObject(1f,1f,1f);

            TTSRY.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(4).scaleObject(1f,1f,1f);

            TTSRY.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(5).scaleObject(1f,1f,1f);

            System.out.println("G");
        }
        if(window.isKeyPressed(GLFW_KEY_H)){
            Vector3f moon = TTSRY.get(3).getModel().transformPosition(new Vector3f(0.0f,0.0f,0f));
            TTSRY.get(5).translateObject(-moon.x,-moon.y,0f);
            TTSRY.get(5).rotateObject((float) Math.toRadians(1f),0f,0f,2f);
            TTSRY.get(5).translateObject(moon.x,moon.y,0f);
            TTSRY.get(5).scaleObject(1f,1f,1f);

        }
        /*if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
            int count = 0;
            for (Object2D object : objectsRectInp) {
                Circle x = (Circle) object;
                if (Math.sqrt(Math.pow(pos.x - x.getCcx(), 2) + Math.pow(pos.y - x.getCcy(), 2)) < 0.05) {
                    count++;
                    drag = true;
                    temp = x;
                }
            }
            if (count > 0) {
                cek = true;
            } else {
                cek = false;
            }
            if ((!(pos.x > 1 || pos.x < -0.99) && !(pos.y > 1 || pos.y < -0.99))) {
                for (Object2D object : objectsRectInp) {
                    Circle x = (Circle) object;
                    jarak = Math.sqrt(Math.pow(pos.x - x.getCcx(), 2) + Math.pow(pos.y - x.getCcy(), 2));
                    if (jarak < 0.175) {
                        collisionFree = false;
                        break;
                    } else {
                        collisionFree = true;
                    }
                }
                if(collisionFree)
                {
                    if (!cek && !drag && noHold == 0) {
                        objectsPointControl.get(0).addVertices(new Vector3f(pos.x,
                                pos.y, 0.0f));

                        objectsRectInp.add(new Circle(shader, new ArrayList<>(List.of()),
                                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                                0.1, pos.x, pos.y, 2, objectsPointControl.get(0).getVerticesSize() - 1));
                        noHold++;
                    }
                    collisionFree = false;
                    if(objectsRectInp.size() % 3 ==0){
                        objectCurve.add(new Curve(
                                Arrays.asList(
                                        //shaderFile lokasi menyesuaikan objectnya
                                        new ShaderProgram.ShaderModuleData(
                                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData(
                                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                                ),
                                objectsPointControl.get(0).getVertices(), new Vector4f(0.0f,1.0f,1.0f,1.0f)
                        ));
                    }
                }
                if (drag && noHold == 0) {
                    temp.MoveObj(pos.x, pos.y);
                    objectsPointControl.get(0).setVertices(temp.getPoinVertices(), new Vector3f(pos.x, pos.y, 0));
                            *//*if(objectCurve.size()>0){
                                objectCurve.get(0).setVertices(((temp.getPoinVertices()+1)/3)-1, new Vector3f(pos.x, pos.y, 0));
                                System.out.println(temp.getPoinVertices());
                            }*//*
                }
            } else {
                drag = false;
                noHold = 0;
            }
        }*/
    }
    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(0.00f, 0.0f, 0.0f, 0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
            for (Sphere obj3D : TTSRY) {
                obj3D.draw(camera,projection);
            }
            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new MainTTSRY().run();
    }
}

