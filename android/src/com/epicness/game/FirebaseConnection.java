package com.epicness.game;

import com.epicness.game.firebase.FirebaseInterface;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.screens.CharacterSelection;
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

    private DatabaseReference charactersReference;
    private DatabaseReference[] moneyReferences;
    private DatabaseReference[] positionReferences;

    FirebaseConnection(final BoardGame game) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gameReference = database.getReference("Game");

        DatabaseReference playersReference = gameReference.child("players");
        moneyReferences = new DatabaseReference[4];
        positionReferences = new DatabaseReference[4];

        charactersReference = gameReference.child("characters");

        // PLAYER 1
        DatabaseReference player1Reference = playersReference.child("player1");
        moneyReferences[0] = player1Reference.child("money");
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
        positionReferences[0] = player1Reference.child("position");
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

        // PLAYER 2
        DatabaseReference player2Reference = playersReference.child("player2");
        moneyReferences[1] = player2Reference.child("money");
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
        positionReferences[1] = player2Reference.child("position");
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

        // PLAYER 3
        DatabaseReference player3Reference = playersReference.child("player3");
        moneyReferences[2] = player3Reference.child("money");
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
        positionReferences[2] = player3Reference.child("position");
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

        // PLAYER 4
        DatabaseReference player4Reference = playersReference.child("player4");
        moneyReferences[3] = player4Reference.child("money");
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
        positionReferences[3] = player4Reference.child("position");
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
    }

    @Override
    public void updateMoney(int player, int money) {
        moneyReferences[player].setValue(money);
        Listener.setLoading(true);
    }

    @Override
    public void updatePosition(int player, int position) {
        positionReferences[player].setValue(position);
        Listener.setLoading(true);
    }

    @Override
    public void addCharacterListener(final String character) {
        charactersReference.child(character).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CharacterSelection.getInstance().updateFromDatabase(
                        character,
                        dataSnapshot.getValue(String.class)
                );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    // La base de datos debe actualizar el dueño de un personaje
    @Override
    public void updateCharacterOwner(String character, String owner) {
        charactersReference.child(character).setValue(owner);
    }

}