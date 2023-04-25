import Engine.*;
import Engine.Object;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window = new Window(1440, 900, "Kelompok Larva");

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

    ArrayList<LarvaObject> LarvaShape = new ArrayList<>();
    ArrayList<LarvaObject> Cemara = new ArrayList<>();
    ArrayList<LarvaMerahObject> LMO = new ArrayList<>();
    ArrayList<LarvaMerahObject> EsKrim = new ArrayList<>();
    ArrayList<LarvaObject> Tanah = new ArrayList<>();
    ArrayList<LarvaObject> Matahari = new ArrayList<>();
    ArrayList<LarvaObject> Ekor = new ArrayList<>();

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
        //eyes
        objectsSphere.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                -1.5f, 1.0f, 0.01f, 0.01f, 0.1f, 64, 32, 0
        ));
        objectsSphere.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                -1.5f, 1.0f, 0.01f, 0.01f, 0.1f, 64, 32, 0
        ));
        //wings
        objectsElipsoid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                -1.5f, 1.0f, 0.4f, 0.5f, 0.3f, 64, 32, 3
        ));
        objectsElipsoid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                -1.5f, 1.0f, 0.4f, 0.5f, 0.3f, 64, 32, 3
        ));
        //body
        objectsElipsoid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                -1.5f, 1.0f, 0.4f, 0.5f, 0.3f, 64, 32, 3
        ));
        //sting
        objectsElipticparaboloid.add(new SphereMike(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\sceneMike.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                -1.5f, 1.0f, 0.01f, 0.01f, 0.1f, 64, 32, 3
        ));
        //eyes
        objectsSphere.get(0).translateObject(-6.9f, 9.9f, -1.2f);
        objectsSphere.get(0).scaleObject(0.05f, 0.08f, 0.05f);
        objectsSphere.get(1).translateObject(-7.9f, 9.9f, -1.2f);
        objectsSphere.get(1).scaleObject(0.05f, 0.08f, 0.05f);
        //body
        objectsElipsoid.get(2).translateObject(-1.5f, 1.3f, 0.0f);
        objectsElipsoid.get(2).scaleObject(0.25f, 0.5f, 0.2f);
        //sting
        objectsElipticparaboloid.get(0).translateObject(-12.3f, 2.2f, 0.0f);
        objectsElipticparaboloid.get(0).scaleObject(0.03f, 0.2f, 0.02f);
//      wings
        objectsElipsoid.get(1).translateObject(-2.4f, 6.8f, 10.0f);
        objectsElipsoid.get(1).scaleObject(0.2f, 0.1f, 0.01f);
        objectsElipsoid.get(0).translateObject(-1.4f, 6.8f, 10.0f);
        objectsElipsoid.get(0).scaleObject(0.2f, 0.1f, 0.01f);
        //tanah
        Tanah.add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(160/255f, 160/255f, 160/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        Tanah.get(0).scaleObject(15f, -0.5f, 2.5f);
        Tanah.get(0).rotateObject(4.75f,1f,0f,0f);
        Tanah.get(0).translateObject(0.69f,-1.5f,-4f);
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
        Cemara.get(0).scaleObject(2.5f, 1f, 2.6f);
        Cemara.get(0).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).translateObject(0.69f,-0.5f,-4f);

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
        Cemara.get(0).getChildObject().get(0).scaleObject(2.1f, 1f, 2.2f);
        Cemara.get(0).getChildObject().get(0).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(0).translateObject(0.79f,-0.15f,-4f);
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
        Cemara.get(0).getChildObject().get(1).scaleObject(1.7f, 1f, 1.8f);
        Cemara.get(0).getChildObject().get(1).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(1).translateObject(0.88f,0.2f,-4f);
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
        Cemara.get(0).getChildObject().get(2).scaleObject(1.3f, 1f, 1.4f);
        Cemara.get(0).getChildObject().get(2).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(2).translateObject(0.98f,0.5f,-4f);

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
        Cemara.get(0).getChildObject().get(3).translateObject(1.29f,-0.7f,-4f);

        //Cemara2 1
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
        Cemara.get(0).getChildObject().get(4).scaleObject(2.5f, 0.5f, 2.6f);
        Cemara.get(0).getChildObject().get(4).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(4).translateObject(1.99f,-0.5f,-2f);

        //Cemara2 2
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
        Cemara.get(0).getChildObject().get(5).scaleObject(2.1f, 0.5f, 2.2f);
        Cemara.get(0).getChildObject().get(5).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(5).translateObject(2.09f,-0.15f,-2f);
        //Cemara2 3
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
        Cemara.get(0).getChildObject().get(6).scaleObject(1.7f, 0.5f, 1.8f);
        Cemara.get(0).getChildObject().get(6).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(6).translateObject(2.18f,0.2f,-2f);
        //Cemara2 4
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
        Cemara.get(0).getChildObject().get(7).scaleObject(1.3f, 0.5f, 1.4f);
        Cemara.get(0).getChildObject().get(7).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(7).translateObject(2.28f,0.5f,-2f);

        //Tangkai pohon2
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
        Cemara.get(0).getChildObject().get(8).scaleObject(0.2f, 0.2f, 0.4f);
        Cemara.get(0).getChildObject().get(8).rotateObject(1.5f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(8).translateObject(2.59f,-0.7f,-2f);

        //Cemara3 1
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
        Cemara.get(0).getChildObject().get(9).scaleObject(2.5f, 0.5f, 2.6f);
        Cemara.get(0).getChildObject().get(9).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(9).translateObject(-5.45f,-0.05f,-6f);

        //Cemara3 2
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
        Cemara.get(0).getChildObject().get(10).scaleObject(2.1f, 0.5f, 2.2f);
        Cemara.get(0).getChildObject().get(10).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(10).translateObject(-5.35f,0.3f,-6f);
        //Cemara3 3
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
        Cemara.get(0).getChildObject().get(11).scaleObject(1.7f, 0.5f, 1.8f);
        Cemara.get(0).getChildObject().get(11).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(11).translateObject(-5.25f,0.6f,-6f);
        //Cemara3 4
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
        Cemara.get(0).getChildObject().get(12).scaleObject(1.3f, 0.5f, 1.4f);
        Cemara.get(0).getChildObject().get(12).rotateObject(4.75f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(12).translateObject(-5.15f,0.85f,-6f);

        //Tangkai pohon3
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
        Cemara.get(0).getChildObject().get(13).scaleObject(0.2f, 0.2f, 0.4f);
        Cemara.get(0).getChildObject().get(13).rotateObject(1.5f,1f,0f,0f);
        Cemara.get(0).getChildObject().get(13).translateObject(-4.79f,-0.25f,-6f);


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
        LarvaShape.get(0).getChildObject().get(2).translateObject(-0.022f, 0.42f, 0.25f);

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
        LarvaShape.get(0).getChildObject().get(3).translateObject(0.13f, 0.42f, 0.25f);


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
        LarvaShape.get(0).getChildObject().get(4).translateObject(-0.06f, 0.42f, 0.29f);
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
        LarvaShape.get(0).getChildObject().get(5).translateObject(0.1f, 0.42f, 0.29f);


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
        LarvaShape.get(0).getChildObject().get(6).translateObject(-0.06f, 0.42f, 0.31f);
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
        LarvaShape.get(0).getChildObject().get(7).translateObject(0.1f, 0.42f, 0.31f);

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
        LarvaShape.get(0).getChildObject().get(8).translateObject(-0.08f, 0.05f, 0.31f);

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
        LarvaShape.get(0).getChildObject().get(9).translateObject(0.24f, 0.05f, 0.21f);

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
        LarvaShape.get(0).getChildObject().get(10).translateObject(0.02f, 0.08f, 0.31f);

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
        LarvaShape.get(0).getChildObject().get(11).translateObject(0.16f, 0.08f, 0.25f);

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
        LarvaShape.get(0).getChildObject().get(12).rotateObject(4.75f, 0.2f, -0.2f, 1f);
        LarvaShape.get(0).getChildObject().get(12).translateObject(0.00f, 0.01f, 0.31f);

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
        LarvaShape.get(0).getChildObject().get(13).rotateObject(4.75f, 0.2f, -0.2f, 1f);
        LarvaShape.get(0).getChildObject().get(13).translateObject(0.02f, 0.0f, 0.31f);

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
        LarvaShape.get(0).getChildObject().get(14).rotateObject(4.75f, 0f, 0f, 1f);
        LarvaShape.get(0).getChildObject().get(14).translateObject(-0.1f, 0.38f, 0.29f);

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
        LarvaShape.get(0).getChildObject().get(15).rotateObject(4.75f, 0f, 0f, 1f);
        LarvaShape.get(0).getChildObject().get(15).translateObject(0.05f, 0.38f, 0.29f);

        //Ekor
        Ekor.add(new LarvaObject(
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
        Ekor.get(0).rotateObject(1.55f, 1f, 0f, 0f);
        Ekor.get(0).translateObject(-0.285f, -0.52f, 0.0f);

        //Belang ekor 1
        Ekor.get(0).getChildObject().add(new LarvaObject(
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
        Ekor.get(0).getChildObject().get(0).rotateObject(1.5f, 0f, 1f, 0f);
        Ekor.get(0).getChildObject().get(0).translateObject(-0.73f, -0.52f, 0.0f);

        //Belang ekor 2
        Ekor.get(0).getChildObject().add(new LarvaObject(
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
        Ekor.get(0).getChildObject().get(1).rotateObject(1.5f, 0f, 1f, 0f);
        Ekor.get(0).getChildObject().get(1).translateObject(-0.5f, -0.53f, 0.0f);

        //Belang ekor 3
        Ekor.get(0).getChildObject().add(new LarvaObject(
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
        Ekor.get(0).getChildObject().get(2).rotateObject(1.5f, 0f, 1f, 0f);
        Ekor.get(0).getChildObject().get(2).translateObject(-0.28f, -0.53f, 0.0f);

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
        LMO.get(0).translateObject(-1.5f,0f,0f);


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
        LMO.get(0).getChildObject().get(0).translateObject(-1.5f, 0.0f, 0.7f);
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
        LMO.get(0).getChildObject().get(1).translateObject(-1.4f, 0.0f, 1.f);
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
        LMO.get(0).getChildObject().get(2).translateObject(-1.48f, 0.0f, 0.4f);
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
        LMO.get(0).getChildObject().get(3).translateObject(-1.85f, -0.43f, 0.0f);

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
        LMO.get(0).getChildObject().get(4).translateObject(-1.51f, 0.25f, 0.3f);

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

        LMO.get(0).getChildObject().get(5).translateObject(-1.2f, 0.25f, 0.3f);
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
        LMO.get(0).getChildObject().get(6).translateObject(-1.5f, 0.25f, 0.3f);
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

        LMO.get(0).getChildObject().get(7).translateObject(-1.18f, 0.25f, 0.3f);
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
        LMO.get(0).getChildObject().get(8).translateObject(-1.5f, 0.25f, 0.3f);

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

        LMO.get(0).getChildObject().get(9).translateObject(-1.18f, 0.25f, 0.3f);

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
        LMO.get(0).getChildObject().get(10).translateObject(-1.53f, -0.03f, 0.36f);
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
        LMO.get(0).getChildObject().get(11).translateObject(-1.4f, 0.09f, 0.3f);
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
        LMO.get(0).getChildObject().get(12).translateObject(-1.3f, 0.09f, 0.3f);
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
        LMO.get(0).getChildObject().get(13).translateObject(-1.35f, 0.01f, 0.3f);
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
        LMO.get(0).getChildObject().get(14).translateObject(-1.33f, 0.3f, 0.36f);

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
        LMO.get(0).getChildObject().get(15).translateObject(-1.05f, 0.3f, 0.36f);

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
        EsKrim.get(0).scaleObject(0.4f, 0.13f, 1.3f);
        EsKrim.get(0).rotateObject(-4.75f,1f,0f,0f);
        EsKrim.get(0).translateObject(-1.465f,-0.23f,0.37f);
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
        EsKrim.get(0).getChildObject().get(0).scaleObject(0.13f, 0.13f, 0.13f);
        EsKrim.get(0).getChildObject().get(0).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(0).translateObject(-1.43f,-0.18f,0.37f);
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
        EsKrim.get(0).getChildObject().get(1).scaleObject(0.13f, 0.13f, 0.13f);
        EsKrim.get(0).getChildObject().get(1).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(1).translateObject(-1.31f,-0.18f,0.37f);
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
        EsKrim.get(0).getChildObject().get(2).scaleObject(0.13f, 0.13f, 0.13f);
        EsKrim.get(0).getChildObject().get(2).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(2).translateObject(-1.36f,-0.09f,0.37f);

        //Segitiga eskrim 2
        EsKrim.get(0).getChildObject().add(new LarvaMerahObject(
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
        EsKrim.get(0).getChildObject().get(3).scaleObject(0.4f, 0.13f, 1.3f);
        EsKrim.get(0).getChildObject().get(3).rotateObject(-4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(3).translateObject(0f,-0.23f,0.35f);
        //eskrim2 1
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
        EsKrim.get(0).getChildObject().get(4).scaleObject(0.13f, 0.13f, 0.13f);
        EsKrim.get(0).getChildObject().get(4).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(4).translateObject(0.05f,-0.18f,0.35f);
        //eskrim2 2
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
        EsKrim.get(0).getChildObject().get(5).scaleObject(0.13f, 0.13f, 0.13f);
        EsKrim.get(0).getChildObject().get(5).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(5).translateObject(0.14f,-0.18f,0.35f);
        //eskrim2 3
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
        EsKrim.get(0).getChildObject().get(6).scaleObject(0.13f, 0.13f, 0.13f);
        EsKrim.get(0).getChildObject().get(6).rotateObject(4.75f,1f,0f,0f);
        EsKrim.get(0).getChildObject().get(6).translateObject(0.1f,-0.09f,0.35f);

        //Matahari Merah
        Matahari.add(new LarvaObject(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\felix\\IdeaProjects\\ProyekGrafkom\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(204/255f, 102/255f, 00/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        Matahari.get(0).scaleObject(0.5f, 0.5f, 0.5f);
        Matahari.get(0).rotateObject(4.75f,1f,0f,0f);
        Matahari.get(0).translateObject(2.3f,1.75f,0.15f);
        //Matahari kuning
        Matahari.get(0).getChildObject().add(new LarvaObject(
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
        Matahari.get(0).getChildObject().get(0).scaleObject(0.4f, 0.35f, 0.4f);
        Matahari.get(0).getChildObject().get(0).rotateObject(4.75f,1f,0f,0f);
        Matahari.get(0).getChildObject().get(0).translateObject(2.3f,1.75f,0.15f);

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
                i.translateObject(0f, 0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0f, -0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(-0.004f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LarvaObject i : LarvaShape) {
                i.translateObject(0.004f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (LarvaObject i : LarvaShape) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LarvaObject i : Ekor) {
                i.translateObject(0f, 0f, 0.004f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LarvaObject i : Ekor) {
                i.translateObject(0f, 0f, -0.004f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (LarvaObject i : Ekor) {
                i.translateObject(0f, 0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LarvaObject i : Ekor) {
                i.translateObject(0f, -0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LarvaObject i : Ekor) {
                i.translateObject(-0.004f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LarvaObject i : Ekor) {
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
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (LarvaMerahObject i : EsKrim) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0f, 0f, 0.004f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LarvaMerahObject i : LMO) {
                i.translateObject(0f, 0f, -0.004f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LarvaMerahObject i : EsKrim) {
                i.translateObject(0f, 0f, 0.004f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LarvaMerahObject i : EsKrim) {
                i.translateObject(0f, 0f, -0.004f);
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

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (LarvaMerahObject i : EsKrim) {
                i.translateObject(0f, 0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LarvaMerahObject i : EsKrim) {
                i.translateObject(0f, -0.004f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LarvaMerahObject i : EsKrim) {
                i.translateObject(-0.004f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LarvaMerahObject i : EsKrim) {
                i.translateObject(0.004f, 0f, 0f);
            }
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

        if (window.isKeyPressed(GLFW_KEY_9)) {
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

//      salto ke blakang
        if (window.isKeyPressed(GLFW_KEY_0)) {
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

    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(255/255f, 178/255f, 102/255f, 1.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            glClearDepth(1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            input();



            for (LarvaObject object3D : Matahari) {
                object3D.draw(camera,projection );
            }

            for (LarvaObject object3D : Tanah) {
                object3D.draw(camera,projection );
            }
            for (LarvaObject object3D : Cemara) {
                object3D.draw(camera,projection );
            }
            for (LarvaObject object3D : LarvaShape) {

                object3D.draw(camera,projection);
            }
            for (LarvaObject object3D : Ekor) {
                object3D.draw(camera,projection );
            }
            for (LarvaMerahObject obj3D : LMO) {

                obj3D.draw(camera,projection);
            }
            for (LarvaMerahObject obj3D : EsKrim) {
                obj3D.draw(camera,projection );
            }
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

            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }
    public static void main (String[]args){
        new Main().run();
    }
}