package Engine;


import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object extends ShaderProgram {
    List<Vector3f> vertices;
    List<Vector3f>verticesColor;
    int vao, vbo;
    int vboColor;
    Vector4f color;
    UniformsMap uniformsMap;
    Matrix4f model;
    List<Object> childObject;
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                    Vector4f color)
    {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.color = color;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();
    }
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                    List<Vector3f> verticesColor)
    {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticeColor();
    }

    public void setupVAOVBO(){
        // set VAO
        vao= glGenVertexArrays();
        glBindVertexArray(vao);
        // set VBO
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);
    }
    public void setupVAOVBOWithVerticeColor(){
        // set VAO
        vao= glGenVertexArrays();
        glBindVertexArray(vao);
        // set VBO
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);
        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }


    public void drawSetupWithVerticeColor(){
        bind();
        //uniformsMap.setUniform("uni_color", color);
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3, GL_FLOAT, false, 0,0);
        //Bind vboColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false,0,0);
    }
    public void drawWithVerticesColor(){
        drawSetupWithVerticeColor();
        //draw the vertices
        //optional
        glLineWidth(10);
        glPointSize(10);

        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

    public void drawSetup(Camera camera, Projection projection){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3, GL_FLOAT, false, 0,0);
    }

    public void drawSetup1(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        // urutannya dari sini, ke vert, ke frag, baru ke layar
    }
    public void draw(Camera camera, Projection projection){
        drawSetup(camera,projection);
        // Draw vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
        for(Object child : getChildObject()){
            child.draw(camera,projection);
        }
    }
    public void draw1(){
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }

    public void drawLine(Camera camera, Projection projection){
        drawSetup(camera,projection);
        // Draw vertices
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }
    //Transformation
    public void translateObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().translate(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        for(Object child : getChildObject()){
            child.translateObject(offsetX,offsetY,offsetZ);
        }
    }
    public void rotateObject(Float degree, Float x, Float y, Float z){
        model = new Matrix4f().rotate(degree,x,y,z).mul(new Matrix4f(model));
        for(Object child : getChildObject()){
            child.rotateObject(degree,x,y,z);
        }
    }
    public void rotateObjectOnPoint(Float degree, Float x,Float y,Float z, Float tempx, Float tempy, Float tempz){
        translateObject(-tempx,-tempy,-tempz);
        model = new Matrix4f().rotate(degree,x,y,z).mul(new Matrix4f(model));
        updateCenterPoint();
        for(Object child:childObject){
            child.rotateObjectOnPoint(degree,x,y,z, tempx,tempy,tempz);
        }
        translateObject(tempx,tempy,tempz);
    }
    public void scaleObject(Float scaleX, Float scaleY, Float scaleZ){
        model = new Matrix4f().scale(scaleX,scaleY,scaleZ).mul(new Matrix4f(model));
        for(Object child : getChildObject()){
            child.scaleObject(scaleX,scaleY,scaleZ);
        }
    }

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0f,0f,0f, centerTemp);
        return centerTemp;
    }
    public int getVerticesSize(){
        return vertices.size();
    }

    public void setVertices(int index,Vector3f newVector){
        vertices.set(index,newVector);
        setupVAOVBO();
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }

    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
    }

    public List<Vector3f> getVerticesColor() {
        return verticesColor;
    }

    public void setVerticesColor(List<Vector3f> verticesColor) {
        this.verticesColor = verticesColor;
    }
    public Matrix4f getModel(){
        return model;
    }

}

