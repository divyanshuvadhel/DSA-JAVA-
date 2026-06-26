import java.util.List;
public class CountMatching {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0;
        int indexRuleKey=0;
        if(ruleKey.equals("color")){
            indexRuleKey=1;
        }else if(ruleKey.equals("name")){
            indexRuleKey=2;
        }
        for(int i=0;i<items.size();i++){
            // for each item contains three elemets
            //rule key and the rule value -> rulekey is index and arr[index]== rule value then count ++
            if(items.get(i).get(indexRuleKey).equals(ruleValue)){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
