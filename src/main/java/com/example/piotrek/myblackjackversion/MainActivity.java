package com.example.piotrek.myblackjackversion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends AppCompatActivity {
    static int counter=1;
    ArrayList<Integer> list = new ArrayList<Integer>();
    static int myPoints=0;
    static int computerPoints=0;
    static boolean stand=false;
    static boolean compStand=false;
    static int myCash=2000;
    static int compCash=2000;
    static int bet=20;
    static int onBet=0;
    static boolean hit;//check hit or double button
    static boolean blockHitAndDouble=false;
    static boolean blockNextRound=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list.add(0x7f030000);
        list.add(0x7f030001);
        list.add(0x7f030002);
        list.add(0x7f030003);
        list.add(0x7f030004);
        list.add(0x7f030005);
        list.add(0x7f030006);
        list.add(0x7f030007);
        list.add(0x7f030008);
        list.add(0x7f030009);
        list.add(0x7f03000a);
        list.add(0x7f03000b);
        list.add(0x7f03000c);
        list.add(0x7f03000d);
        list.add(0x7f03000e);
        list.add(0x7f03000f);
        list.add(0x7f030010);
        list.add(0x7f030011);
        list.add(0x7f030012);
        list.add(0x7f030013);
        list.add(0x7f030014);
        list.add(0x7f030015);
        list.add(0x7f030016);
        list.add(0x7f030017);
        list.add(0x7f030018);
        list.add(0x7f030019);
        list.add(0x7f03001a);
        list.add(0x7f03001b);
        list.add(0x7f03001c);
        list.add(0x7f03001d);
        list.add(0x7f03001e);
        list.add(0x7f03001f);
        list.add(0x7f030020);
        list.add(0x7f030021);
        list.add(0x7f030022);
        list.add(0x7f030023);
        list.add(0x7f030024);
        list.add(0x7f030025);
        list.add(0x7f030026);
        list.add(0x7f030029);
        list.add(0x7f03002a);
        list.add(0x7f03002b);
        list.add(0x7f03002c);
        list.add(0x7f03002d);
        list.add(0x7f03002e);
        list.add(0x7f03002f);
        list.add(0x7f030030);
        list.add(0x7f030031);
        list.add(0x7f030032);
        list.add(0x7f030033);
        list.add(0x7f030034);
        list.add(0x7f030035);




    }
    public void startGameMethod(View v) {
        setContentView(R.layout.game_layout);
        myCash=2000;
        compCash=2000;
        counter=1;
    }
    public void showRulesMethod(View v) {
        setContentView(R.layout.rules_layout);
    }
    public void exitMethod(View v) {
        System.exit(0);
    }
    public void menuMethod(View view) {
        setContentView(R.layout.activity_main);
    }
    public void nextRoundMethod(View v) {
        if(myCash<=0||compCash<=0){
            setContentView(R.layout.win_or_lose_layout);
            TextView A=(TextView)findViewById(R.id.textViewIfWin);
            if(myCash<=0){
                A.setText("YUO LOSE. COMPUTER WIN");
            }
            else{A.setText("YOU WIN. COMPUTER LOSE");}
        }
        if (!blockNextRound){
            setContentView(R.layout.game_layout);
            counter = 1;
            myPoints = 0;
            computerPoints = 0;
            stand = false;
            compStand = false;
            bet = 20;
            onBet = 0;
            showBetting(myCash, compCash, hit, onBet);
            blockHitAndDouble = false;
            blockNextRound=true;
        }
    }

    public void doubleButtonMethod(View v){
        if(!blockHitAndDouble) {
            String myString = String.valueOf(counter);
            Random randCard = new Random();
            int number = randCard.nextInt(52);


            //FirstClick
            if (myString.equals("1")) {
                ImageView computerFirstCard = (ImageView) findViewById(R.id.imageView2);
                ImageView myFirstCard = (ImageView) findViewById(R.id.imageView1);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerFirstCard.setImageBitmap(computerCard1);
                if (!stand) myFirstCard.setImageBitmap(myCard1);
                if (!compStand) computerFirstCard.setVisibility(View.VISIBLE);
                if (!stand) myFirstCard.setVisibility(View.VISIBLE);
            }
            //SecondClick
            if (myString.equals("2")) {
                ImageView computerSecondCard = (ImageView) findViewById(R.id.imageView4);
                ImageView mySecondCard = (ImageView) findViewById(R.id.imageView3);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerSecondCard.setImageBitmap(computerCard1);
                if (!stand) mySecondCard.setImageBitmap(myCard1);
                if (!compStand) computerSecondCard.setVisibility(View.VISIBLE);
                if (!stand) mySecondCard.setVisibility(View.VISIBLE);
            }
            //ThirdClick
            if (myString.equals("3")) {
                ImageView computerThirdCard = (ImageView) findViewById(R.id.imageView6);
                ImageView myThirdCard = (ImageView) findViewById(R.id.imageView5);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerThirdCard.setImageBitmap(computerCard1);
                if (!stand) myThirdCard.setImageBitmap(myCard1);
                if (!compStand) computerThirdCard.setVisibility(View.VISIBLE);
                if (!stand) myThirdCard.setVisibility(View.VISIBLE);
            }
            //FourthClick
            if (myString.equals("4")) {
                ImageView computerFourthCard = (ImageView) findViewById(R.id.imageView8);
                ImageView myFourthCard = (ImageView) findViewById(R.id.imageView7);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerFourthCard.setImageBitmap(computerCard1);
                if (!stand) myFourthCard.setImageBitmap(myCard1);
                if (!compStand) computerFourthCard.setVisibility(View.VISIBLE);
                if (!stand) myFourthCard.setVisibility(View.VISIBLE);
            }
            //FifthClick
            if (myString.equals("5")) {
                ImageView computerFifthCard = (ImageView) findViewById(R.id.imageView10);
                ImageView myFifthCard = (ImageView) findViewById(R.id.imageView9);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerFifthCard.setImageBitmap(computerCard1);
                if (!stand) myFifthCard.setImageBitmap(myCard1);
                if (!compStand) computerFifthCard.setVisibility(View.VISIBLE);
                if (!stand) myFifthCard.setVisibility(View.VISIBLE);
            }
            //SixthClick
            if (myString.equals("6")) {
                ImageView computerSixthCard = (ImageView) findViewById(R.id.imageView12);
                ImageView mySixthCard = (ImageView) findViewById(R.id.imageView11);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerSixthCard.setImageBitmap(computerCard1);
                if (!stand) mySixthCard.setImageBitmap(myCard1);
                if (!compStand) computerSixthCard.setVisibility(View.VISIBLE);
                if (!stand) mySixthCard.setVisibility(View.VISIBLE);
            }

            counter++;
            showComputerPoints(computerPoints);
            showMyPoints(myPoints);
            if ((stand && compStand) || myPoints >= 21 || computerPoints >= 21)
                checkWinMethod(myPoints, computerPoints);
            if (!stand) {
                hit = false;
                bet *= 2;
                myCash -= bet;
                compCash -= bet;
                onBet += (2 * bet);
                showBetting(myCash, compCash, hit, onBet);
            }
        }
    }
    public void hitButtonMethod(View v){
        if(!blockHitAndDouble) {
            String myString = String.valueOf(counter);
            Random randCard = new Random();
            int number = randCard.nextInt(52);


            //FirstClick
            if (myString.equals("1")) {
                ImageView computerFirstCard = (ImageView) findViewById(R.id.imageView2);
                ImageView myFirstCard = (ImageView) findViewById(R.id.imageView1);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerFirstCard.setImageBitmap(computerCard1);
                if (!stand) myFirstCard.setImageBitmap(myCard1);
                if (!compStand) computerFirstCard.setVisibility(View.VISIBLE);
                if (!stand) myFirstCard.setVisibility(View.VISIBLE);
            }
            //SecondClick
            if (myString.equals("2")) {
                ImageView computerSecondCard = (ImageView) findViewById(R.id.imageView4);
                ImageView mySecondCard = (ImageView) findViewById(R.id.imageView3);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerSecondCard.setImageBitmap(computerCard1);
                if (!stand) mySecondCard.setImageBitmap(myCard1);
                if (!compStand) computerSecondCard.setVisibility(View.VISIBLE);
                if (!stand) mySecondCard.setVisibility(View.VISIBLE);
            }
            //ThirdClick
            if (myString.equals("3")) {
                ImageView computerThirdCard = (ImageView) findViewById(R.id.imageView6);
                ImageView myThirdCard = (ImageView) findViewById(R.id.imageView5);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerThirdCard.setImageBitmap(computerCard1);
                if (!stand) myThirdCard.setImageBitmap(myCard1);
                if (!compStand) computerThirdCard.setVisibility(View.VISIBLE);
                if (!stand) myThirdCard.setVisibility(View.VISIBLE);
            }
            //FourthClick
            if (myString.equals("4")) {
                ImageView computerFourthCard = (ImageView) findViewById(R.id.imageView8);
                ImageView myFourthCard = (ImageView) findViewById(R.id.imageView7);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerFourthCard.setImageBitmap(computerCard1);
                if (!stand) myFourthCard.setImageBitmap(myCard1);
                if (!compStand) computerFourthCard.setVisibility(View.VISIBLE);
                if (!stand) myFourthCard.setVisibility(View.VISIBLE);
            }
            //FifthClick
            if (myString.equals("5")) {
                ImageView computerFifthCard = (ImageView) findViewById(R.id.imageView10);
                ImageView myFifthCard = (ImageView) findViewById(R.id.imageView9);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerFifthCard.setImageBitmap(computerCard1);
                if (!stand) myFifthCard.setImageBitmap(myCard1);
                if (!compStand) computerFifthCard.setVisibility(View.VISIBLE);
                if (!stand) myFifthCard.setVisibility(View.VISIBLE);
            }
            //SixthClick
            if (myString.equals("6")) {
                ImageView computerSixthCard = (ImageView) findViewById(R.id.imageView12);
                ImageView mySixthCard = (ImageView) findViewById(R.id.imageView11);
                final Bitmap computerCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!compStand) computerPoints += checkPoints(number, computerPoints);
                number = randCard.nextInt(52);
                final Bitmap myCard1 = BitmapFactory.decodeResource(getResources(), list.get(number));
                if (!stand) myPoints += checkPoints(number, myPoints);
                if (!compStand) computerSixthCard.setImageBitmap(computerCard1);
                if (!stand) mySixthCard.setImageBitmap(myCard1);
                if (!compStand) computerSixthCard.setVisibility(View.VISIBLE);
                if (!stand) mySixthCard.setVisibility(View.VISIBLE);
            }

            counter++;
            showComputerPoints(computerPoints);
            showMyPoints(myPoints);
            if ((stand && compStand) || myPoints >= 21 || computerPoints >= 21)
                checkWinMethod(myPoints, computerPoints);
            if (!stand && !compStand) {
                hit = true;
                myCash -= bet;
                compCash -= bet;
                onBet += (2 * bet);
                showBetting(myCash, compCash, hit, onBet);
            }
        }
    }
    public int checkPoints(int number,int points){

        if((number>=0&&number<=3)|| (number>=13&&number <=16)||(number>=26&&number<=29)||(number>=39&&number<=42)) return 10;
        else if(number==5||number==18||number==31||number==44) return 2;
        else if(number==6||number==19||number==32||number==45) return 3;
        else if(number==7||number==20||number==33||number==46) return 4;
        else if(number==8||number==21||number==34||number==47) return 5;
        else if(number==9||number==22||number==35||number==48) return 6;
        else if(number==10||number==23||number==36||number==49) return 7;
        else if(number==11||number==24||number==37||number==50) return 8;
        else if(number==12||number==25||number==38||number==51) return 9;
        else {
            if(points>=11)return 1;
            else return 11;
        }

    }

    public void showMyPoints(int points){
        View v=findViewById(R.id.button2);
        TextView A=(TextView)findViewById(R.id.textViewMyPoints);
        A.setText(String.valueOf(points));
        if(points>21){
            standButtonMethod(v);
        }
    }
    public void showComputerPoints(int points){
        TextView B=(TextView)findViewById(R.id.textViewComputerPoints);
        B.setText(String.valueOf(points));
        if(points>=18) compStand=true;
    }
    public void standButtonMethod(View v){
        stand=true;
        while (!compStand)hitButtonMethod(v);
        checkWinMethod(myPoints,computerPoints);
    }
    public void checkWinMethod(int myPoints,int compPoints) {
    showBetting(myCash,compCash,hit,onBet);
        if((myPoints==21||myPoints>compPoints||compPoints>21)&&myPoints<22) {
            Toast.makeText(getApplicationContext(), "YouWin", Toast.LENGTH_LONG).show();
            myCash+=onBet;
            onBet=0;
            bet=20;
        }
        else if((compPoints==21||compPoints>myPoints||myPoints>21)&&compPoints<22) {
            Toast.makeText(getApplicationContext(), "ComputerWin", Toast.LENGTH_LONG).show();
            compCash+=onBet;
            onBet=0;
            bet=20;
        }
        else {
            Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_LONG).show();
            myCash+=(0.5*onBet);
            compCash+=(0.5*onBet);
            onBet=0;
            bet=20;
        }
        blockHitAndDouble=true;
        blockNextRound=false;
    }
    public void showBetting(int myCash,int compCash,boolean hit,int onBet){
        TextView A = (TextView) findViewById(R.id.textViewYourCash);
        A.setText("Your cash:" + String.valueOf(myCash) + "$");
        TextView B = (TextView) findViewById(R.id.textViewCompCash);
        B.setText("Comp. cash:" + String.valueOf(compCash) + "$");
        TextView C = (TextView) findViewById(R.id.textViewBet);
        C.setText("Bet:" + String.valueOf(bet) + "$");
        TextView D = (TextView) findViewById(R.id.textViewNowBet);
        D.setText("Now in bet:"+String.valueOf(onBet)+"$");
    }
}
