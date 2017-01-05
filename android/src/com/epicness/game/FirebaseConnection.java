package com.epicness.game;

import com.epicness.game.actors.Board;
import com.epicness.game.actors.Player;
import com.epicness.game.firebase.FirebaseInterface;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.screens.CharacterSelection;
import com.epicness.game.screens.MainMenu;
import com.epicness.game.screens.tabs.BuyFactorsAction;
import com.epicness.game.screens.tabs.FactorsTab;
import com.epicness.game.screens.tabs.ThrowDiceToMoveAction;
import com.epicness.game.screens.tabs.ThrowFirstDiceAction;
import com.epicness.game.screens.tabs.UpgradeCardsAction;
import com.epicness.game.screens.tabs.WaitAction;
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

    private DatabaseReference gameStartedReference;
    private DatabaseReference[] capitalReferences;
    private DatabaseReference[] characterReferences;
    private DatabaseReference[] currentActionIndexReferences;
    private DatabaseReference[] landReferences;
    private DatabaseReference[] moneyReferences;
    private DatabaseReference[] phoneIDReferences;
    private DatabaseReference[] positionReferences;
    private DatabaseReference[] sectorReferences;
    private DatabaseReference[] workforceReferences;
    private DatabaseReference turnReference;

    FirebaseConnection() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gameReference = database.getReference("Game");

        gameStartedReference = gameReference.child("gameStarted");

        DatabaseReference playersReference = gameReference.child("players");
        capitalReferences = new DatabaseReference[4];
        characterReferences = new DatabaseReference[4];
        currentActionIndexReferences = new DatabaseReference[4];
        landReferences = new DatabaseReference[4];
        moneyReferences = new DatabaseReference[4];
        phoneIDReferences = new DatabaseReference[4];
        positionReferences = new DatabaseReference[4];
        sectorReferences = new DatabaseReference[4];
        workforceReferences = new DatabaseReference[4];

        // Assign references
        for (int i = 0; i < 4; i++) {
            DatabaseReference currentPlayerReference = playersReference.child("player" + i);
            capitalReferences[i] = currentPlayerReference.child("capital");
            characterReferences[i] = currentPlayerReference.child("character");
            currentActionIndexReferences[i] = currentPlayerReference.child("currentActionIndex");
            landReferences[i] = currentPlayerReference.child("land");
            moneyReferences[i] = currentPlayerReference.child("money");
            phoneIDReferences[i] = currentPlayerReference.child("phoneID");
            positionReferences[i] = currentPlayerReference.child("position");
            sectorReferences[i] = currentPlayerReference.child("sectors");
            workforceReferences[i] = currentPlayerReference.child("workforce");
        }

        turnReference = gameReference.child("turn");
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
    public void setCurrentActionIndex(int player, int actionIndex) {
        currentActionIndexReferences[player].setValue(actionIndex);
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
    public void setSectors(int player, String sectors) {
        sectorReferences[player].setValue(sectors);
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
    public void getCurrentActionIndex(final int player) {
        currentActionIndexReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int actionIndex = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().currentActionIndexDBUpdate(player, actionIndex);
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

    @Override
    public void getSectors(final int player) {
        sectorReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String sectors = dataSnapshot.getValue(String.class);
                PlayerManager.getInstance().sectorsDBUpdate(player, sectors);
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
    public void getTurn() {
        turnReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int playerTurn = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().turnDBUpdate(playerTurn);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void getGameStarted() {
        gameStartedReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean gameStarted = dataSnapshot.getValue(Boolean.class);
                PlayerManager.getInstance().setGameStarted(gameStarted);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void refreshCharacterSelection() {
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            characterReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String character = dataSnapshot.getValue(String.class);
                    PlayerManager.getInstance().characterDBUpdate(finalI, character);
                    if (finalI == 3) {
                        CharacterSelection.getInstance().doneRefreshing();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void refreshWaitAction() {
        turnReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int turn = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().turnDBUpdate(turn);
                WaitAction.getInstance().doneRefreshing();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void action1(final int player, final int workforce, final int land, final int capital) {
        workforceReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int DBworkforce = dataSnapshot.getValue(Integer.class);
                int newWorkforce = DBworkforce + workforce;
                PlayerManager.getInstance().updateWorkforce(player, newWorkforce);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        landReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int DBland = dataSnapshot.getValue(Integer.class);
                int newLand = DBland + land;
                PlayerManager.getInstance().updateLand(player, newLand);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        capitalReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int DBCapital = dataSnapshot.getValue(Integer.class);
                int newCapital = DBCapital + capital;
                PlayerManager.getInstance().updateCapital(player, newCapital);
                capitalReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ThrowFirstDiceAction.getInstance().doneAction1();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void action2(final int player, final int diceResult) {
        positionReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int DBPosition = dataSnapshot.getValue(Integer.class);
                int finalPosition;
                if (diceResult + DBPosition >= 17) {
                    finalPosition = diceResult + DBPosition - 17;
                } else {
                    finalPosition = diceResult + DBPosition;
                }
                PlayerManager.getInstance().updatePosition(player, finalPosition);
                moneyReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final int currentMoney = dataSnapshot.getValue(Integer.class);
                        final Player[] currentPlayer = {PlayerManager.getInstance().getPlayers()[player]};
                        int cellIndex = currentPlayer[0].getPosition();
                        final int sector = Board.getInstance().getCell(cellIndex).getSectorIndex();
                        final int[] moneyToGive = {0};
                        sectorReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String sectors = dataSnapshot.getValue(String.class);
                                PlayerManager.getInstance().sectorsDBUpdate(player, sectors);
                                currentPlayer[0] = PlayerManager.getInstance().getPlayers()[player];
                                switch (sector) {
                                    case 1:
                                        moneyToGive[0] = currentPlayer[0].getHumanDevelopment() * 50;
                                        break;
                                    case 2:
                                        moneyToGive[0] = currentPlayer[0].getInfrastructure() * 50;
                                        break;
                                    case 3:
                                        moneyToGive[0] = currentPlayer[0].getNaturalResources() * 50;
                                        break;
                                    case 4:
                                        moneyToGive[0] = currentPlayer[0].getTechnology() * 50;
                                        break;
                                }
                                PlayerManager.getInstance().updateMoney(player, currentMoney + moneyToGive[0]);
                                moneyReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        ThrowDiceToMoveAction.getInstance().doneAction2();
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void gameStartedAdvice(final boolean gameStarted) {
        gameStartedReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean DBgameStarted = dataSnapshot.getValue(Boolean.class);
                // Si los datos no concuerdan
                if (DBgameStarted != gameStarted) {
                    gameStartedReference.setValue(gameStarted);
                }
                gameStartedReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        turnReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int turn = dataSnapshot.getValue(Integer.class);
                                PlayerManager.getInstance().turnDBUpdate(turn);
                                CharacterSelection.getInstance().doneGettingGameStarted(gameStarted);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private int currentActionIndex;

    @Override
    public void refreshCurrentActionIndexes() {
        currentActionIndex = -1;
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            currentActionIndexReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int DBCurrentActionIndex = dataSnapshot.getValue(Integer.class);
                    PlayerManager.getInstance().currentActionIndexDBUpdate(finalI, DBCurrentActionIndex);
                    if (PlayerManager.getInstance().getPlayerIndex() == finalI) {
                        currentActionIndex = DBCurrentActionIndex;
                    }
                    if (finalI == 3) {
                        CharacterSelection.getInstance().doneRefreshingActionIndexes(currentActionIndex);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void refreshFactorCards(final int player) {
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            sectorReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String sectors = dataSnapshot.getValue(String.class);
                    PlayerManager.getInstance().sectorsDBUpdate(player, sectors);
                    if (finalI == 3) {
                        FactorsTab.getInstance().doneRefreshingFactorCards();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void buyFactor(final int player, final int factor) {
        moneyReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int money = dataSnapshot.getValue(Integer.class);
                PlayerManager.getInstance().moneyDBUpdate(player, money);
                if (money >= 100) {
                    PlayerManager.getInstance().updateMoney(player, money - 100);
                    moneyReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            switch (factor) {
                                // workforce
                                case 0:
                                    workforceReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            int DBWorkforce = dataSnapshot.getValue(Integer.class);
                                            PlayerManager.getInstance().updateWorkforce(player, DBWorkforce + 1);
                                            workforceReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    BuyFactorsAction.getInstance().doneBuyingFactor();
                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                // land
                                case 1:
                                    landReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            int DBLand = dataSnapshot.getValue(Integer.class);
                                            PlayerManager.getInstance().updateLand(player, DBLand + 1);
                                            landReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    BuyFactorsAction.getInstance().doneBuyingFactor();
                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                // capital
                                case 2:
                                    capitalReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            int DBCapital = dataSnapshot.getValue(Integer.class);
                                            PlayerManager.getInstance().updateCapital(player, DBCapital + 1);
                                            capitalReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    BuyFactorsAction.getInstance().doneBuyingFactor();
                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                BuyFactorsAction.getInstance().doneBuyingFactor();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void refreshFactorsToUpgradeCard(final int card) {
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            workforceReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int DBWorkforce = dataSnapshot.getValue(Integer.class);
                    PlayerManager.getInstance().workforceDBUpdate(finalI, DBWorkforce);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            landReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int DBLand = dataSnapshot.getValue(Integer.class);
                    PlayerManager.getInstance().landDBUpdate(finalI, DBLand);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            capitalReferences[i].addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int DBCapital = dataSnapshot.getValue(Integer.class);
                    PlayerManager.getInstance().capitalDBUpdate(finalI, DBCapital);
                    if (finalI == 3) {
                        UpgradeCardsAction.getInstance().doneRefreshingFactorsToUpgradeCard(card);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void upgradeCard(final int player, final int factor) {
        sectorReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Obtain DB data
                String sectors = dataSnapshot.getValue(String.class);
                // update local data
                PlayerManager.getInstance().sectorsDBUpdate(player, sectors);
                String newSectors = "";
                String[] indexes = sectors.split(",");
                int newValue;
                switch (factor) {
                    case 0:
                        newValue = 1 + Integer.parseInt(indexes[0]);
                        indexes[0] = newValue + "";
                        break;
                    case 1:
                        newValue = 1 + Integer.parseInt(indexes[1]);
                        indexes[1] = newValue + "";
                        break;
                    case 2:
                        newValue = 1 + Integer.parseInt(indexes[2]);
                        indexes[2] = newValue + "";
                        break;
                    case 3:
                        newValue = 1 + Integer.parseInt(indexes[3]);
                        indexes[3] = newValue + "";
                        break;
                }
                for (int i = 0; i < 4; i++) {
                    if (i == 3) {
                        newSectors += indexes[i] + "";
                    } else {
                        newSectors += indexes[i] + ",";
                    }
                }
                PlayerManager.getInstance().updateSectors(player, newSectors);
                sectorReferences[player].addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        UpgradeCardsAction.getInstance().doneUpgradingCard();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}