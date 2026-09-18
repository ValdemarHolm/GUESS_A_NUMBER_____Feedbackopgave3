void main() {
    Scanner input = new Scanner(System.in);
    int randomNumber;
    int lives;
    int bestScore=0;
    int easyBS=10000;   //bliver sat til en unlikely reachable score
    int mediumBS=10000; //bliver sat til en umulig reachable score
    int hardBS=10000;   //bliver sat til en umulig reachable score

    while (1>0) {
        showMenu();
        lives=chooseDifficulty(easyBS,mediumBS,hardBS, bestScore);
        while (lives==0) {
            showMenu();
            lives=chooseDifficulty(easyBS,mediumBS,hardBS, bestScore);
        }
        randomNumber=generateNumber(lives);
        bestScore=playGame(randomNumber, lives);
        easyBS=calculateEasyBS(bestScore, easyBS);
        mediumBS=calculateMediumBS(bestScore, mediumBS);
        hardBS=calculateHardBS(bestScore, hardBS);
        System.out.println("Vil du spille igen? (ja/nej)");
        String again = input.next();
        if (again.equalsIgnoreCase("nej")) {
            break;
        }
    }
    printStats(easyBS,mediumBS,hardBS, bestScore);
}

static void showMenu() {
    System.out.println("--------------------");
    System.out.println(" GÆT ET TAL SPILLET");
    System.out.println(" VÆLG SVÆRHEDSGRAD");
    System.out.println("--------------------");
    System.out.println();
    System.out.println("1. LET");
    System.out.println("2. MELLEM");
    System.out.println("3. SVÆR");
    System.out.println("4. STATS");
    System.out.println("5. SLUK");
    System.out.println("");
    System.out.print("Indtast her: ");  //brugerinput bliver behandlet i chooseDifficulty
}

static int chooseDifficulty(int easyBS, int mediumBS, int hardBS, int bestScore) {
    Scanner input = new Scanner(System.in);
    String difficulty="";
    String range="";
    int lives=0;
    int choice = input.nextInt();

    if (choice==4) {
        printStats(easyBS, mediumBS, hardBS);
    } else if (choice==5) {
        printStats(easyBS, mediumBS, hardBS, bestScore);
        System.exit(0);
    }

    switch (choice) {
        case 1:
            difficulty = "LET";
            range = "1-10";
            lives = -1;
            break;
        case 2:
            difficulty = "MELLEM";
            range = "1-50";
            lives = 10;
            break;
        case 3:
            difficulty = "SVÆR";
            range = "1-100";
            lives = 7;
            break;
    }

    if (lives!=0) {
        System.out.println("Du har valgt " + difficulty + " og skal gætte et tal mellem " + range);
        if (lives == -1) {
            System.out.println("Du har ubegrænset antal gæt");
        } else {
            System.out.println("Du har " + lives + " forsøg til at gætte tallet");
        }
        System.out.print("Hvad gætter du: ");
    }
    return lives;
}

static int generateNumber(int lives) {
    int difficulty=0;
    int randomNumber;
    if (lives == -1) {
        difficulty = 10;
    } else if (lives == 10) {
        difficulty = 50;
    } else if (lives == 7) {
        difficulty = 100;
    }
    randomNumber = (int)(Math.random() * difficulty) + 1;
    return randomNumber;
}

static int playGame(int randomNumber, int lives) {
    Scanner input = new Scanner(System.in);
    int guess = 0;     //guess er brugers gæt
    int guesses = 0;   //guesses er hvor mange gæt brugeren har gættet
    int bestScore=0;
    int originalLives = lives;

    while ((guess!=randomNumber)&&(lives!=0)) {
        guess = input.nextInt();
        if (guess == randomNumber) {
            System.out.println("Korrekt!");
            guesses++;
            if (originalLives == -1) {
                bestScore = guesses+100;
            } else if (originalLives == 10) {
                bestScore = guesses+200;
            } else if (originalLives == 7) {
                bestScore = guesses+300;
            }
        } else if (guess > randomNumber) {
            System.out.println("Du er for høj");
            guesses++;
            lives--;
        } else if (guess < randomNumber) {
            System.out.println("Du er for lav");
            guesses++;
            lives--;
        }
        if ((lives>0)&&(guess!=randomNumber)) {
            System.out.println("Du har " + lives + " forsøg tilbage");
            System.out.print("Hvad gætter du: ");
        } else if ((lives<0)&&(guess!=randomNumber)){  //hvis man er på LET sværhedsgrad
            System.out.print("Hvad gætter du: ");
        }
    }

    if (lives==0) {
        System.out.println("Du har brugt alle dine liv");
        System.out.println("Tallet var " + randomNumber);
    } else {
        System.out.println("Du brugte " + guesses + " forsøg");
    }
    return bestScore;
}


static int calculateEasyBS(int bestScore, int easyBS) {
    int actualScore=bestScore-100;
    if  (actualScore<0) {

    } else if (actualScore>100) {

    } else if (actualScore<easyBS) {
        easyBS=actualScore;
    }
    return easyBS;
}

static int calculateMediumBS(int bestScore, int mediumBS) {
    int actualScore=bestScore-200;
    if (actualScore<=0) {

    } else if (actualScore>100) {

    } else if (actualScore<mediumBS) {
        mediumBS=actualScore;
    }
    return mediumBS;
}

static int calculateHardBS(int bestScore, int hardBS) {
    int actualScore=bestScore-300;
    if (actualScore<=0) {

    } else if (actualScore>100) {

    } else if (actualScore<hardBS) {
        hardBS=actualScore;
    }
    return hardBS;
}

static void printStats(int easyBS, int mediumBS, int hardBS, int bestScore) { //bliver printet når man slukker spillet
    Scanner input = new Scanner(System.in);
    System.out.println("--------------------");
    System.out.println("       STATS");
    System.out.println("--------------------");
    System.out.println("");
    if (easyBS==10000) {
        System.out.println("Din highscore på LET er NULL");
    } else if (easyBS!=10000) {
        System.out.println("Din highscore på LET er " + easyBS);
    }
    if (mediumBS==10000) {
        System.out.println("Din highscore på MELLEM er NULL");
    } else if (mediumBS!=10000) {
        System.out.println("Din highscore på MELLEM er " + mediumBS);
    }
    if (hardBS==10000) {
        System.out.println("Din highscore på SVÆR er NULL");
    } else if (hardBS!=10000) {
        System.out.println("Din highscore på SVÆR er " + hardBS);
    }
}

static void printStats(int easyBS, int mediumBS, int hardBS) {  //bliver printet hvis man har valgt STATS i menu
    Scanner input = new Scanner(System.in);
    System.out.println("--------------------");
    System.out.println("       STATS");
    System.out.println("--------------------");
    System.out.println("");
    if (easyBS==10000) {
        System.out.println("Din highscore på LET er NULL");
    } else if (easyBS!=10000) {
        System.out.println("Din highscore på LET er " + easyBS);
    }
    if (mediumBS==10000) {
        System.out.println("Din highscore på MELLEM er NULL");
    } else if (mediumBS!=10000) {
        System.out.println("Din highscore på MELLEM er " + mediumBS);
    }
    if (hardBS==10000) {
        System.out.println("Din highscore på SVÆR er NULL");
    } else if (hardBS!=10000) {
        System.out.println("Din highscore på SVÆR er " + hardBS);
    }
    System.out.println("");
    System.out.print("Tast tilfældig tast for at vende tilbage til menu: ");
    String indtasther = input.nextLine(); //indtasther bliver ikke brugt andre steder da det ikke er nødvendigt
}