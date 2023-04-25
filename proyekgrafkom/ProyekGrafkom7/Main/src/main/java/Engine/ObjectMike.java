package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class ObjectMike extends ShaderProgram {
    List<Vector3f> vertices;//buat nyimpen titik2 yang mau digambar
    List<Vector3f> verticesColor;//color
    UniformsMap uniformsMap;

    int vao, vbo;
    int vboColor;
    Vector4f color;
    public Matrix4f model;

    public List<Object> getChildObject() {return childObject; }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }

    List<Object>childObject;

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f, centerTemp);
        return centerTemp;
    }

    public ObjectMike(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap((getProgramId()));
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        model = new Matrix4f();
        childObject = new ArrayList<>();
    }

    public ObjectMike(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }
    public void setupVAOVBO () {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

    }

    //  public void setupVAOVBOBerzier(){
//        // set vao
//        vao = glGenVertexArrays();
//        glBindVertexArray(vao);
//
//        vbo = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, vbo);
//        // mengirim vertices ke shader
//        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesCurve), GL_STATIC_DRAW);
//    }
    public void setupVAOVBOWithVerticesColor () {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }
    public void draw () {
        drawSetup();
        //draw the vertices
        //optional
        glLineWidth(10);
        glPointSize(10);

        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }
    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        // urutannya dari sini, ke vert, ke frag, baru ke layar
    }
    public void drawSetupWithVerticesColor () {
        bind();

        //bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }//rainbowshit

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        //draw the vertices
        //optional
        glLineWidth(10);
        glPointSize(10);

        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

    public void drawLine(){
//        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(1); //ketebalan garis
        glPointSize(1); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }

    public void addVertices(Vector3f newVertices){
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }

    public void rotateObject(Float degree, Float x, Float y, Float z){
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
    }

    public void scaleObject(Float scaleX, Float scaleY, Float scaleZ){
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
    }

}
