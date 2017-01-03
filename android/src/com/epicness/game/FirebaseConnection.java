package com.epicness.game;

import com.epicness.game.firebase.FirebaseInterface;
import com.epicness.game.firebase.SetterManager;
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

    private DatabaseReference[] capitalReferences;
    private DatabaseReference[] characterReferences;
    private DatabaseReference[] landReferences;
    private DatabaseReference[] moneyReferences;
    private DatabaseReference[] phoneIDReferences;
    private DatabaseReference[] positionReferences;
    private DatabaseReference[] workforceReferences;

    FirebaseConnection() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gameReference = database.getReference("Game");

        DatabaseReference playersReference = gameReference.child("players");
        capitalReferences = new DatabaseReference[4];
        characterReferences = new DatabaseReference[4];
        landReferences = new DatabaseReference[4];
        moneyReferences = new DatabaseReference[4];
        phoneIDReferences = new DatabaseReference[4];
        positionReferences = new DatabaseReference[4];
        workforceReferences = new DatabaseReference[4];

        // Assign references
        for (int i = 0; i < 4; i++) {
            DatabaseReference currentPlayerReference = playersReference.child("player" + i);
            capitalReferences[i] = currentPlayerReference.child("capital");
            characterReferences[i] = currentPlayerReference.child("character");
            landReferences[i] = currentPlayerReference.child("land");
            moneyReferences[i] = currentPlayerReference.child("money");
            phoneIDReferences[i] = currentPlayerReference.child("phoneID");
            positionReferences[i] = currentPlayerReference.child("position");
            workforceReferences[i] = currentPlayerReference.child("workforce");
        }
    }

    //---------------------------
    //          SETTERS
    //---------------------------

    @Override
    public void setCapital(int player, int capital) {
        capitalReferences[player].setValue(capital);
    }

    @Override
    public void setCharacter(int player, String character) {
        characterReferences[player].setValue(character);
    }

    @Override
    public void setLand(int player, int land) {
        landReferences[player].setValue(land);
    }

    @Override
    public void setMoney(int player, int money) {
        moneyReferences[player].setValue(money);
    }

    @Override
    public void setPhoneID(int player, String phoneID) {
        phoneIDReferences[player].setValue(phoneID);
    }

    @Override
    public void setPosition(int player, int position) {
        positionReferences[player].setValue(position);
    }

    @Override
    public void setWorkforce(int player, int workforce) {
        workforceReferences[player].setValue(workforce);
    }

    //---------------------------
    //          GETTERS
    //---------------------------

    @Override
    public void getCapital(final int player) {
        capitalReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int capital = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().capitalDBUpdate(player, capital);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getCharacter(final int player) {
        characterReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String character = dataSnapshot.getValue(String.class);
                PlayerManager.getInstance().characterDBUpdate(player, character);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getLand(final int player) {
        landReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int land = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().landDBUpdate(player, land);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getMoney(final int player) {
        moneyReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int money = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().moneyDBUpdate(player, money);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getPhoneID(final int player) {
        phoneIDReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String phoneID = dataSnapshot.getValue(String.class);
                PlayerManager.getInstance().phoneIDDBUpdate(player, phoneID);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getPosition(final int player) {
        positionReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int position = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().positionDBUpdate(player, position);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getWorkforce(final int player) {
        workforceReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int workforce = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().workforceDBUpdate(player, workforce);
                if (MainMenu.getInstance().isRequestingData()) {
                    MainMenu.getInstance().doneLoadingData();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //---------------------------
    //           OTHER
    //---------------------------

    private int phoneIDIndex;

    @Override
    public void verifyPhoneID(final String phoneID) {
        phoneIDIndex = -1;
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            phoneIDReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String currentPhoneID = dataSnapshot.getValue(String.class);
                    if (currentPhoneID.equals(phoneID)) {
                        phoneIDIndex = finalI;
                    }
                    if (finalI == 3) {
                        MainMenu.getInstance().doneVerifyingPhoneID(phoneIDIndex);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void requestPlayerForPhoneID(final String phoneID) {
        phoneIDIndex = -1;
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            phoneIDReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String currentPhoneID = dataSnapshot.getValue(String.class);
                    if (currentPhoneID.equals("none")) {
                        phoneIDIndex = finalI;
                    }
                    if (finalI == 3) {
                        MainMenu.getInstance().doneRequestingPlayerForPhoneID(phoneIDIndex);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    private int characterIndex;

    @Override
    public void verifyCharacter(final String character) {
        characterIndex = -1;
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            characterReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String currentCharacter = dataSnapshot.getValue(String.class);
                    if (currentCharacter.equals(character)) {
                        characterIndex = finalI;
                    }
                    if (finalI == 3) {
                        CharacterSelection.getInstance().doneVerifyingCharacter(character, characterIndex);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void requestCharacter(String character) {

    }

}