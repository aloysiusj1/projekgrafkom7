import Engine.*;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class larvaMerah {
    private Window window = new Window(800, 800, "C14210020_Aloysius Juan");
    ArrayList<LarvaMerahObject> LMO = new ArrayList<>();
    ArrayList<LarvaMerahObject> EsKrim = new ArrayList<>();
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
        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(0.30f, 0.34f, 6.54f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
        //badan atas
        LMO.add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(202/255f, 30/255f, 30/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.80f,
                0.35f,
                0.4f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        LMO.get(0).scaleObject(0.50f, 2.0f, 1.0f);
        LMO.get(0).rotateObject(1.55f, 0.0f, 1f, 0f);


        //  Antena tengah
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(202/255f, 30/255f, 30/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.25f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LMO.get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, 0.7f);
        LMO.get(0).getChildObject().get(0).rotateObject(4.75f, 1f, 0f, 0f);

        // Antena kiri
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(202/255f, 30/255f, 30/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LMO.get(0).getChildObject().get(1).translateObject(0.0f, 0.0f, 0.6f);
        LMO.get(0).getChildObject().get(1).rotateObject(4.75f, 1f, 0.2f, 0f);

        // Antena kanan
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(202/255f, 30/255f, 30/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LMO.get(0).getChildObject().get(2).translateObject(0.0f, 0.0f, 0.6f);
        LMO.get(0).getChildObject().get(2).rotateObject(4.75f, 1f, -0.2f, 0f);;


        //Badan Bawah
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(202/255f, 30/255f, 30/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.3f,
                0.1f,
                0.3f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        LMO.get(0).getChildObject().get(3).rotateObject(1.55f, 1.0f, 0f, 0f);
        LMO.get(0).getChildObject().get(3).translateObject(-0.35f, -0.43f, 0.0f);

        //White Eye kiri
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.05f,
                0.03f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LMO.get(0).getChildObject().get(4).translateObject(-0.01f, 0.25f, 0.3f);

        //White Eye kanan
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.03f,
                0.02f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LMO.get(0).getChildObject().get(5).rotateObject(0.0f, 0f, 0f, 1f);

        LMO.get(0).getChildObject().get(5).translateObject(0.3f, 0.25f, 0.3f);
        //red eye kiri
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LMO.get(0).getChildObject().get(6).translateObject(0.0f, 0.25f, 0.3f);
        //red eye kanan
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        //LGMO.get(0).getChildObject().get(9).rotateObject(-0.4f, 0f, 0f, 1f);

        LMO.get(0).getChildObject().get(7).translateObject(0.32f, 0.25f, 0.3f);
        //Black Eye kiri
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.001f,
                0.001f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LMO.get(0).getChildObject().get(8).translateObject(0.0f, 0.25f, 0.3f);

        //Black Eye kanan
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.001f,
                0.001f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        //LGMO.get(0).getChildObject().get(9).rotateObject(-0.4f, 0f, 0f, 1f);

        LMO.get(0).getChildObject().get(9).translateObject(0.32f, 0.25f, 0.3f);

        //mouth
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.35f,
                0.3f,
                0.02f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LMO.get(0).getChildObject().get(10).rotateObject(4.75f, 0f, 0f, 1f);
        LMO.get(0).getChildObject().get(10).translateObject(-0.03f, -0.03f, 0.36f);
        //lobang kiri
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.001f,
                0.001f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LMO.get(0).getChildObject().get(11).translateObject(0.10f, 0.09f, 0.3f);
        //lobang kanan
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.001f,
                0.001f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LMO.get(0).getChildObject().get(12).translateObject(0.20f, 0.09f, 0.3f);
        // Kumis
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
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
                0.15f,
                0.05f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LMO.get(0).getChildObject().get(13).translateObject(0.15f, 0.01f, 0.3f);
        //kelopak mata kiri
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(112/255f, 7/255f, 7/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.32f,
                0.02f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LMO.get(0).getChildObject().get(14).rotateObject(-4.75f, 0f, 0f, 1f);
        LMO.get(0).getChildObject().get(14).translateObject(0.15f, 0.3f, 0.36f);

        //kelopak mata kanan
        LMO.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(112/255f, 7/255f, 7/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.25f,
                0.02f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LMO.get(0).getChildObject().get(15).rotateObject(-4.75f, 0f, 0f, 1f);
        LMO.get(0).getChildObject().get(15).translateObject(0.43f, 0.3f, 0.36f);

        //Segitiga eskrim
        EsKrim.add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(182/255f, 118/255f, 44/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                6));
        EsKrim.get(0).scaleObject(1.5f, 0.7f, 3.6f);
        EsKrim.get(0).rotateObject(-4.75f,1f,0f,0f);
        EsKrim.get(0).translateObject(0.85f,-0.2f,0f);
        //eskrim 1
        EsKrim.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(195/255f, 130/255f, 180/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        EsKrim.get(0).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.5f);
        EsKrim.get(0).getChildObject().get(0).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(0).translateObject(1f,-0.15f,0.15f);
        //eskrim 2
        EsKrim.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(102/255f, 51/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        EsKrim.get(0).getChildObject().get(1).scaleObject(0.5f, 0.5f, 0.5f);
        EsKrim.get(0).getChildObject().get(1).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(1).translateObject(1.5f,-0.15f,0.15f);
        //eskrim 3
        EsKrim.get(0).getChildObject().add(new LarvaMerahObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(246/255f, 204/255f, 67/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        EsKrim.get(0).getChildObject().get(2).scaleObject(0.5f, 0.5f, 0.5f);
        EsKrim.get(0).getChildObject().get(2).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(2).translateObject(1.25f,0.16f,0.15f);
    }


    public void input() {

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (LarvaMerahObject i : LMO) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (LarvaMerahObject i : LMO) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (LarvaMerahObject i : LMO) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (LarvaMerahObject i : LMO) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (LarvaMerahObject i : LMO) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (LarvaMerahObject i : LMO) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0f, 0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0f, -0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(-0.004f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0.004f, 0f, 0f);
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
        if (window.isKeyPressed(GLFW_KEY_1)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_2)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_3)) {
            for (LarvaMerahObject i : EsKrim){
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_4)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_5)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(126/255f, 216/255f, 243/255f, 1.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            glClearDepth(1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            input();
            for (LarvaMerahObject obj3D : LMO) {

                obj3D.draw(camera,projection);
            }
            for (LarvaMerahObject obj3D : EsKrim) {
                obj3D.draw(camera,projection );
            }
            System.out.println("X"+camera.getPosition().get(0));
            System.out.println("Y"+camera.getPosition().get(1));
            System.out.println("Z"+camera.getPosition().get(2));

            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new larvaMerah().run();
    }
}