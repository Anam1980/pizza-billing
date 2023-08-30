package com.driver;

public class Pizza {

    final int Vegpizzabaseprice = 300;
    final int Nonvegpizzabaseprice = 400;
     final int ExtraCheesePrice = 80;
    final int ExtraToppingsForVegPizza = 70;
    final int ExtraToppingsForNonvegPizza = 120;
    final int PaperbagPrice = 20;
    public boolean isAskforPaperBag;
    private int price;
    private Boolean isVeg;

    private String bill;

    public boolean isAskforCheese;
    public boolean isAskforToppings;
    public int baseprice;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        this.isAskforCheese=false;
        this.isAskforToppings=false;
        this.isAskforPaperBag=false;
        if(isVeg){
            //veg
           this.price += Vegpizzabaseprice;
           this.baseprice = Vegpizzabaseprice;
        }
        else{
            //nonveg
            this.price += Nonvegpizzabaseprice;
            this.baseprice = Nonvegpizzabaseprice;
        }


    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){

        if(!isAskforCheese){
            this.price+= this.ExtraCheesePrice;
            isAskforCheese = true;
        }


    }

    public void addExtraToppings(){
        if(isAskforCheese==false){
            return;
        }
        if(!isAskforToppings) {
            if (isVeg) {
                //veg
                this.price += this.ExtraToppingsForVegPizza;
            } else {
                //nonveg
                this.price += this.ExtraToppingsForNonvegPizza;
            }
            isAskforToppings=true;
        }

    }

    public void addTakeaway(){

            this.price += this.PaperbagPrice;
            isAskforPaperBag =true;


    }

    public String getBill(){
       bill = "Base Price Of The Pizza: " + baseprice +"\n";
        if(isAskforCheese){
            bill += "Extra Cheese Added: "+ ExtraCheesePrice+"\n";
        }
        if(isAskforToppings){
            bill += "Extra Toppings Added: "+ ((isVeg)? ExtraToppingsForVegPizza : ExtraToppingsForNonvegPizza)+"\n";
        }
       if(isAskforPaperBag){
             bill += "Paperbag Added: "+PaperbagPrice+"\n";
       }

       bill += "Total Price: "+this.price+"\n";
        return this.bill;
    }
}
