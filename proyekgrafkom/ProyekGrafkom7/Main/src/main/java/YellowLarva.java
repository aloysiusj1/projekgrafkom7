import Engine.*;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class YellowLarva {
    private Window window = new Window(800, 800, "C14210050_Felix Jonathan");
    ArrayList<LarvaObject> LarvaShape = new ArrayList<>();
    ArrayList<LarvaObject> Cemara = new ArrayList<>();

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
        glEnable(GL_DEPTH_TEST);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glDepthMask(true);
        glDepthFunc(GL_LEQUAL);
        glDepthRange(5.0f, 1.0f);

        camera.setPosition(0.0f, 0.4f, 7f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));

        //Badan kepala
        LarvaShape.add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255f, 255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.7f,
                0.3f,
                0.3f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        LarvaShape.get(0).scaleObject(0.45f, 2.5f, 1f);
        LarvaShape.get(0).rotateObject(1.55f,0f,1f,0f);

        // tangkai antena
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255f, 255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.3f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LarvaShape.get(0).getChildObject().get(0).translateObject(0.0f, 0f, 0.65f);
        LarvaShape.get(0).getChildObject().get(0).rotateObject(4.75f, 1f, 0f, 0f);

        //pentol antena
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 153/255f, 51/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.045f,
                0.045f,
                0.045f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        LarvaShape.get(0).getChildObject().get(1).translateObject(0.00f, 0.98f, 0.05f);

        //Ekor
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255f, 255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.25f,
                0.11f,
                0.24f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LarvaShape.get(0).getChildObject().get(2).rotateObject(1.55f, 1f, 0f, 0f);
        LarvaShape.get(0).getChildObject().get(2).translateObject(-0.285f, -0.52f, 0.0f);

        //Putih mata kiri
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255f, 255f, 255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.02f,
                0.08f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(3).translateObject(-0.022f, 0.42f, 0.25f);

        //Putih mata kanan
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.02f,
                0.08f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(4).translateObject(0.13f, 0.42f, 0.25f);


        //Kuning mata kiri
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(204/255f, 204/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.014f,
                0.014f,
                0.014f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(5).translateObject(-0.06f, 0.42f, 0.29f);
        //Kuning mata kanan
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(204/255f, 204/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.014f,
                0.014f,
                0.014f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(6).translateObject(0.1f, 0.42f, 0.29f);


        //Hitam Mata kiri
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.009f,
                0.009f,
                0.009f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(7).translateObject(-0.06f, 0.42f, 0.31f);
        //Hitam Mata kanan
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.009f,
                0.009f,
                0.009f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        //LGMO.get(0).getChildObject().get(6).rotateObject(-0.4f, 0f, 0f, 1f);
        LarvaShape.get(0).getChildObject().get(8).translateObject(0.1f, 0.42f, 0.31f);

        //Pink pipi kiri
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 204/255f, 204/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.02f,
                0.02f,
                0.02f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(9).translateObject(-0.08f, 0.05f, 0.31f);

        //Pink pipi kanan
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 204/255f, 204/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.02f,
                0.02f,
                0.02f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        //LGMO.get(0).getChildObject().get(6).rotateObject(-0.4f, 0f, 0f, 1f);
        LarvaShape.get(0).getChildObject().get(10).translateObject(0.24f, 0.05f, 0.21f);

        //Hidung kiri
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.01f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(11).translateObject(0.02f, 0.08f, 0.31f);

        //Hidung kanan
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.01f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LarvaShape.get(0).getChildObject().get(12).translateObject(0.16f, 0.08f, 0.25f);

        //Luar mulut
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.33f,
                0.2f,
                0f,
                15, // Stack -->a
                30, // Sector --> Titik
                2));
        LarvaShape.get(0).getChildObject().get(13).rotateObject(4.75f, 0.2f, -0.2f, 1f);
        LarvaShape.get(0).getChildObject().get(13).translateObject(0.00f, 0.01f, 0.31f);

        //Mulut
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(51/255f, 0f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.3f,
                0.16f,
                0f,
                15, // Stack -->a
                30, // Sector --> Titik
                2));
        LarvaShape.get(0).getChildObject().get(14).rotateObject(4.75f, 0.2f, -0.2f, 1f);
        LarvaShape.get(0).getChildObject().get(14).translateObject(0.02f, 0.0f, 0.31f);

        //kelopak mata kiri
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(204/255f, 204/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.15f,
                0f,
                15, // Stack -->a
                30, // Sector --> Titik
                2));
        LarvaShape.get(0).getChildObject().get(15).rotateObject(4.75f, 0f, 0f, 1f);
        LarvaShape.get(0).getChildObject().get(15).translateObject(-0.1f, 0.38f, 0.29f);

        //kelopak mata kanan
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(204/255f, 204/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.15f,
                0f,
                15, // Stack -->a
                30, // Sector --> Titik
                2));
        LarvaShape.get(0).getChildObject().get(16).rotateObject(4.75f, 0f, 0f, 1f);
        LarvaShape.get(0).getChildObject().get(16).translateObject(0.05f, 0.38f, 0.29f);

        //Belang ekor 1
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(253/255f, 153/255f, 51/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.1f,
                0.1f,
                0.04f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LarvaShape.get(0).getChildObject().get(17).rotateObject(1.5f, 0f, 1f, 0f);
        LarvaShape.get(0).getChildObject().get(17).translateObject(-0.73f, -0.52f, 0.0f);

        //Belang ekor 2
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(253/255f, 153/255f, 51/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.25f,
                0.21f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LarvaShape.get(0).getChildObject().get(18).rotateObject(1.5f, 0f, 1f, 0f);
        LarvaShape.get(0).getChildObject().get(18).translateObject(-0.5f, -0.53f, 0.0f);

        //Belang ekor 3
        LarvaShape.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(253/255f, 153/255f, 51/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.25f,
                0.22f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LarvaShape.get(0).getChildObject().get(19).rotateObject(1.5f, 0f, 1f, 0f);
        LarvaShape.get(0).getChildObject().get(19).translateObject(-0.28f, -0.53f, 0.0f);
        //Cemara 1
        Cemara.add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(25/255f, 51/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        Cemara.get(0).scaleObject(2.5f, 0.5f, 2.6f);
        Cemara.get(0).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).translateObject(0.45f,-0.5f,0f);

        //Cemara 2
        Cemara.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(25/255f, 51/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        Cemara.get(0).getChildObject().get(0).scaleObject(2.1f, 0.5f, 2.2f);
        Cemara.get(0).getChildObject().get(0).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(0).translateObject(0.55f,-0.15f,0f);
        //Cemara 3
        Cemara.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(25/255f, 51/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        Cemara.get(0).getChildObject().get(1).scaleObject(1.7f, 0.5f, 1.8f);
        Cemara.get(0).getChildObject().get(1).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(1).translateObject(0.64f,0.2f,0f);
        //Cemara 4
        Cemara.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(25/255f, 51/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        Cemara.get(0).getChildObject().get(2).scaleObject(1.3f, 0.5f, 1.4f);
        Cemara.get(0).getChildObject().get(2).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(2).translateObject(0.74f,0.5f,0f);

        //Tangkai pohon
        Cemara.get(0).getChildObject().add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(51/255f, 25/255f, 0f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        Cemara.get(0).getChildObject().get(3).scaleObject(0.2f, 0.2f, 0.4f);
        Cemara.get(0).getChildObject().get(3).rotateObject(1.5f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(3).translateObject(1.05f,-0.7f,-0.1f);




    }
    public void input() {

        if (window.isKeyPressed(GLFW_KEY_1)) {
            for (LarvaObject i : Cemara) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_2)) {
            for (LarvaObject i : Cemara) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_3)) {
            for (LarvaObject i : Cemara){
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_4)) {
            for (LarvaObject i : Cemara) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_5)) {
            for (LarvaObject i : Cemara) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.12f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(0.02f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.moveLeft(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.moveRight(0.02f);
        }
    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(128/255f, 128/255f, 128/255f, 1.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            glClearDepth(1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            input();
            for (LarvaObject object3D : LarvaShape) {

                object3D.draw(camera,projection);
            }
            for (LarvaObject object3D : Cemara) {
                object3D.draw(camera,projection );
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
        new YellowLarva().run();
    }
}