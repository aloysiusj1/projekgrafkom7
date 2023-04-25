package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Rectangle extends Object2D{
    List<Integer> index;
    int ibo; // --> index buffer object = ibo atau == element buffer object
    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                     List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                     List<Vector3f> verticesColor) {
        super(shaderModuleDataList, vertices, verticesColor);
    }

    public void draw(){
        drawSetup();
        // Draw vertices
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLE_FAN, index.size(), GL_UNSIGNED_INT, 0);
        // GL_TRIANGLES & TRIANGLE_FAN nutup sendiri saat sudah ada 3 titik, dan sudah ada 2 garis

    }

    public void createCurve(){

    }

}
