package com.epicness.game;

import com.epicness.game.firebase.FirebaseInterface;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.screens.CharacterSelection;
import com.epicness.game.screens.MainMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Groxar on 09/11/2016.
 * Hello :D
 */

class FirebaseConnection implements FirebaseInterface {

    // Referencias que se crean en el constructor y se usan en otros métodos
    private DatabaseReference playersReference;
    private DatabaseReference[] moneyReferences;
    private DatabaseReference[] positionReferences;
    private DatabaseReference[] phoneIDReferences;
    private DatabaseReference[] characterReferences;

    // Constructor, crea las referencias
    FirebaseConnection() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gameReference = database.getReference("Game");

        playersReference = gameReference.child("players");
        moneyReferences = new DatabaseReference[4];
        positionReferences = new DatabaseReference[4];
        phoneIDReferences = new DatabaseReference[4];
        characterReferences = new DatabaseReference[4];

        // PLAYER 0
        DatabaseReference player0Reference = playersReference.child("player0");
        moneyReferences[0] = player0Reference.child("money");
        moneyReferences[0].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateMoney(0, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        positionReferences[0] = player0Reference.child("position");
        positionReferences[0].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePosition(0, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phoneIDReferences[0] = player0Reference.child("phoneID");
        phoneIDReferences[0].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePhoneID(0, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        characterReferences[0] = player0Reference.child("character");
        characterReferences[0].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateCharacter(0, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // PLAYER 1
        DatabaseReference player1Reference = playersReference.child("player1");
        moneyReferences[1] = player1Reference.child("money");
        moneyReferences[1].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateMoney(1, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        positionReferences[1] = player1Reference.child("position");
        positionReferences[1].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePosition(1, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phoneIDReferences[1] = player1Reference.child("phoneID");
        phoneIDReferences[1].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePhoneID(1, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        characterReferences[1] = player1Reference.child("character");
        characterReferences[1].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateCharacter(1, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // PLAYER 2
        DatabaseReference player2Reference = playersReference.child("player2");
        moneyReferences[2] = player2Reference.child("money");
        moneyReferences[2].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateMoney(2, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        positionReferences[2] = player2Reference.child("position");
        positionReferences[2].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePosition(2, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phoneIDReferences[2] = player2Reference.child("phoneID");
        phoneIDReferences[2].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePhoneID(2, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        characterReferences[2] = player2Reference.child("character");
        characterReferences[2].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateCharacter(2, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // PLAYER 3
        // BY CONVENTION THE LAST PLAYER'S ON DATA CHANGE WILL BE USED AS THE MOMENT
        // WHEN WE'RE DONE LOADING STUFF FROM THE DATABASE
        DatabaseReference player3Reference = playersReference.child("player3");
        moneyReferences[3] = player3Reference.child("money");
        moneyReferences[3].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateMoney(3, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        positionReferences[3] = player3Reference.child("position");
        positionReferences[3].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePosition(3, dataSnapshot.getValue(Integer.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        phoneIDReferences[3] = player3Reference.child("phoneID");
        phoneIDReferences[3].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePhoneID(3, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        characterReferences[3] = player3Reference.child("character");
        characterReferences[3].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateCharacter(3, dataSnapshot.getValue(String.class));
                Listener.setLoading(false);
                MainMenu.getInstance().setLoading("");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    // Updates que vienen desde la aplicación hacia la base de datos

    // La base de datos debe actualizar el dinero de un jugador
    @Override
    public void setMoney(int player, int money) {
        moneyReferences[player].setValue(money);
        Listener.setLoading(true);
    }

    // La base de datos debe actualizar la posición de un jugador
    @Override
    public void setPosition(int player, int position) {
        positionReferences[player].setValue(position);
        Listener.setLoading(true);
    }

    // La base de datos debe actualizar un jugador que ha sido tomado o dejado
    @Override
    public void setPlayerPhoneID(int player, String phoneID) {
        phoneIDReferences[player].setValue(phoneID);
    }

    // La base de datos debe actualizar el dueño de un personaje
    @Override
    public void setCharacter(int player, String character) {
        characterReferences[player].setValue(character);
    }

    // Los requests necesitan un listener

    @Override
    public void getPlayerAssignment(final int player, String phoneID) {
        phoneIDReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updatePlayerAssignmentFromDatabase(
                        player,
                        dataSnapshot.getValue(String.class)
                );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getCharacterAssignment(final int player, String character) {
        characterReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PlayerManager.getInstance().updateCharacterAssignmentFromDatabase(
                        player,
                        dataSnapshot.getValue(String.class)
                );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}