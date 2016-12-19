package com.epicness.game;

import com.epicness.game.firebase.FirebaseInterface;
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

    DatabaseReference[] moneyReferences = new DatabaseReference[4];

    FirebaseConnection(final BoardGame game) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gameReference = database.getReference("Game");
        gameReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("CHANGE");
                System.out.println(dataSnapshot.getRef());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference playersReference = gameReference.child("players");
        DatabaseReference[] playerReferences = new DatabaseReference[4];
        // Create the references to the fields of a player
        for (int i = 1; i <= 4; i++) {
            playerReferences[i - 1] = playersReference.child("player" + i);
            moneyReferences[i - 1] = playerReferences[i - 1].child("money");
            moneyReferences[i - 1].addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    System.out.println("money changed " + dataSnapshot.getValue(Integer.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }
}
