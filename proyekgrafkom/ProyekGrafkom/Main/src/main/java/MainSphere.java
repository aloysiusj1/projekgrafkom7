import Engine.*;
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

public class MainSphere {
    private Window window =
            new Window(800, 800, "Rumah");
    ArrayList<Object2D> objectsRect = new ArrayList<Object2D>();
    ArrayList<Object2D> objectsCirc = new ArrayList<Object2D>();
    ArrayList<Object2D> objectsStar = new ArrayList<Object2D>();
    ArrayList<Object2D> objectsPointControl = new ArrayList<Object2D>();
    ArrayList<Object2D> objectsRectInp = new ArrayList<Object2D>();
    ArrayList<Object2D> objectCurve = new ArrayList<Object2D>();
    ArrayList<Sphere> object3D = new ArrayList<>();
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
        // Langit
        objectsRect.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,1.0f,0.0f),// Top right
                                new Vector3f(-1.0f,1.0f,0.0f),// Top Left
                                new Vector3f(-1.0f,-1.0f,0.0f),// Bot left
                                new Vector3f(1.0f,-1.0f,0.0f)//Bot Right

                        )
                ), new Vector4f(0.0f,0.0f,1.0f,0.0f),
                Arrays.asList(0,1,2,0,2,3)

        ));

        // RUmput
        objectsRect.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(1.0f,-0.5f,0.0f),// Top right
                                        new Vector3f(-1.0f,-0.5f,0.0f),// Top Left
                                        new Vector3f(-1.0f,-1.0f,0.0f),// Bot left
                                        new Vector3f(1.0f,-1.0f,0.0f)//Bot Right
                                )
                        ),
                        new Vector4f(0.0f,0.575f,0.0f,0.0f),
                    Arrays.asList(0,1,2,0,2,3)
                )
        );
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
                0.00001f,
                0.00001f,
                0.00001f,
                3,
                5, // Sector --> Titik
                3));

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

            if (window.getMouseInput().isLeftButtonPressed()) {
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
                            /*if(objectCurve.size()>0){
                                objectCurve.get(0).setVertices(((temp.getPoinVertices()+1)/3)-1, new Vector3f(pos.x, pos.y, 0));
                                System.out.println(temp.getPoinVertices());
                            }*/
                        }
                } else {
                    drag = false;
                    noHold = 0;
                }
            }
        }
        public void loop() {
            while (window.isOpen()) {
                window.update();
                    glClearColor(0.00f, 0.0f, 0.0f, 0.0f); // RapidTables.com (RGB color code chart)
                GL.createCapabilities();
                input();
                for (Object2D object2dR : objectsRect) {
                    object2dR.draw();
                }
                for (Object2D object2dC : objectsCirc) {
                    object2dC.draw();
                }
                for (Object2D object2dS : objectsStar) {
                    object2dS.draw();
                }
                for (Object2D object2dDraw : objectsPointControl) {
                    object2dDraw.drawLine();
                }

                for (Object2D object2dDraw : objectCurve) {
                    object2dDraw.drawLine();
                }
                for (Object2D object2dDraw : objectsRectInp) {
                    object2dDraw.draw();
                }
                for (Sphere obj3D : object3D) {
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
            new MainSphere().run();
        }
    }

