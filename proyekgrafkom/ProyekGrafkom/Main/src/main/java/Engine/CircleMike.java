package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class CircleMike extends ObjectMike {
    float centerx;
    float centery;
    float radius;

    public CircleMike(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerx, float centery, float radius) {
        super(shaderModuleDataList, vertices, color);
        this.centerx = centerx;
        this.centery = centery;
        this.radius = radius;
        createCircle();
        setupVAOVBO();
    }

    public void createCircle() {

        vertices.clear();

        for (double i = 0; i < 360; i += 0.01f) {
            float x = (float) (centerx + radius * Math.cos(Math.toRadians(i)));
            float y = (float) (centery + radius * Math.sin(Math.toRadians(i)));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }


    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(3);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }
}