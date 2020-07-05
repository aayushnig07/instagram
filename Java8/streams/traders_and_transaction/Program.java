package Java8.streams.traders_and_transaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    static Trader raoul=new Trader("Raoul", "Cambridge");
    static Trader mario=new Trader("Mario", "Milan");
    static Trader alan=new Trader("Alan", "Cambridge");
    static Trader brian=new Trader("Brian", "Cambridge");

    static List<Transaction> transacton = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(alan, 2012, 950)
    );

    public static void main(String[]args){
        sortedTransactionValueIn2011(2011);
        uniqueCitiesWhereTraderWorked();
        sortedTraderFromCity("Cambridge");
        sortedTraderNames();
        anyTraderFromCity("Milan");
        transactionValueFromTraderInCity("Cambridge");
    }

    public static void sortedTransactionValueIn2011(int year){
        List<Integer> sortedValue = transacton.stream().filter(y->y.getYear()==year).map(Transaction::getValue).sorted().collect(Collectors.toList());
        System.out.println(sortedValue);
    }

    public static void uniqueCitiesWhereTraderWorked(){
        List<String> cityName = transacton.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println(cityName);
    }

    public static void sortedTraderFromCity(String city){
        List<String> traderNames = transacton.stream().map(Transaction::getTrader).filter(t->t.getCity().equals(city)).map(Trader::getName).sorted().collect(Collectors.toList());
        System.out.println(traderNames);
    }

    public static void sortedTraderNames(){
        List<String>sortedTraderNames = transacton.stream().map(Transaction::getTrader).map(Trader::getName).sorted().collect(Collectors.toList());
        System.out.println(sortedTraderNames);
    }

    public static void anyTraderFromCity(String city){
        boolean anyTrader = transacton.stream().map(Transaction::getTrader).anyMatch(c->c.getCity().equals(city));
        System.out.println(anyTrader);
    }

    public static void transactionValueFromTraderInCity(String city){
        List<Integer> values = transacton.stream().filter(t->t.getTrader().getCity().equals(city)).map(Transaction::getValue).collect(Collectors.toList());
        System.out.println(values);
    }
    
}