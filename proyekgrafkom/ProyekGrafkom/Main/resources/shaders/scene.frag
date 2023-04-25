#version 330
out vec4 frag_color;
uniform vec4 uni_color;
// in -> mendapat data dari luar frag
// out -> mengeluarkan data dari frag
// tidak bisa pakai code ini di frag --> layout (location=0) in vec3 position;
void main() {
    //frag_color = vec4(1.0, 0.0, 0.0, 1.0); --> Param vec4(red,green,blue,alpha)
    frag_color = uni_color;
}