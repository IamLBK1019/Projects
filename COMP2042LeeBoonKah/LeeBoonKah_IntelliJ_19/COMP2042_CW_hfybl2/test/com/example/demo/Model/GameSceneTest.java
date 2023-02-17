package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSceneTest {

    @Test
    void setN() {
        GameScene.setN(4);
        assertEquals(4,GameScene.n);
    }
}