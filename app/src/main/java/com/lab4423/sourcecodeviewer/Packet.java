package com.lab4423.sourcecodeviewer;

public class Packet {
    private ResourceFile file;
    private Brush bursh;

    public Packet(ResourceFile file, Brush brush) {
        this.file = file;
        this.bursh = brush;
    }

    public ResourceFile getFile() {
        return this.file;
    }

    public void setFile(ResourceFile file) {
        this.file = file;
    }

    public Brush getBursh() {
        return bursh;
    }

    public void setBursh(Brush bursh) {
        this.bursh = bursh;
    }
}