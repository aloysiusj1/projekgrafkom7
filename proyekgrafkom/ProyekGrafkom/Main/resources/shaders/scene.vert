#version 330
layout (location=0) in vec3 position;
uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;
// Perkalian antara model dan vec4 Position harus selalu sprt dibwh, dibaca dari kanan
void main() {
    gl_Position = projection * view * model * vec4(position, 1.0);
}