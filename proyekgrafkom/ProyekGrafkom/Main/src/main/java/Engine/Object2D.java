package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object2D extends ShaderProgram {
    List<Vector3f> vertices;
    List<Vector3f>verticesColor;
    int vao, vbo;
    int vboColor;
    Vector4f color;
    UniformsMap uniformsMap;


    public Object2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                    Vector4f color)
    {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.color = color;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
    }
    public Object2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
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
    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3, GL_FLOAT, false, 0,0);

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
    public void draw(){
        drawSetup();
        // Draw vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }
    public void drawWithVerticeColor(){
        drawSetupWithVerticeColor();

        glLineWidth(1);
        glPointSize(0);

        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT

        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }
    public void drawLine(){
        drawSetup();
        // Draw vertices
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }

    public int getVerticesSize(){
        return vertices.size();
    }

    public void setVertices(int index,Vector3f newVector){
        vertices.set(index,newVector);
        setupVAOVBO();
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
}
