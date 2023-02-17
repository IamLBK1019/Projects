package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @Test
    void getLabelScore() {
        Account.makeNewAccount("hello1", 645);
        assertEquals(645, Account.GetLabelScore(0));
    }

    @Test
    void getLabelName() {
        Account.makeNewAccount("hello1", 645);
        assertEquals("hello1", Account.GetLabelName(0));
    }

    @Test
    void getSize() {
        Account.makeNewAccount("hello1", 645);
        Account.makeNewAccount("hello2", 645);
        Account.makeNewAccount("hello3", 1045);
        assertEquals(3,Account.GetSize());
    }
}



