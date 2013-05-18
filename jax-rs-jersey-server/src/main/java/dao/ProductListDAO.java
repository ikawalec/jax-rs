package dao;

import java.util.ArrayList;
import java.util.List;

public class ProductListDAO {

    private List<String> list;

    public ProductListDAO(){
        list = new ArrayList<String>();
    }

    public void add(String name){
        list.add(name);
    }

    public String get(int id){
        return list.get(id);
    }

    public void delete(int id){
        list.remove(id);
    }

    public void update(int id, String name){
        list.set(id, name);
    }

    public List<String> getAll(){
        return list;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(String item : list){
            result.append(item);
            result.append("\n");
        }
        return result.toString();
    }

    public String search(String name, String limit) {
        StringBuilder result = new StringBuilder();
        int max = Integer.valueOf(limit);
        int counter = 0;
        for(String product : list){
            if(product.contains(name)){
                result.append(product);
                result.append("\n");
            }
            if(counter == max){
                return result.toString();
            }
        }
        return result.toString();
    }
}
