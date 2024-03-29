public class 신규_아이디_추천_72410 {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("\\.{2,}", ".");
        if(new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if(new_id.equals(".")) {
            new_id = "";
        } else if(new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if(new_id.equals("")) {
            new_id = "a";
        }
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }
        if(new_id.length() <= 2) {
            while(new_id.length() < 3) {
                new_id = new_id + new_id.charAt(new_id.length() - 1);
            }
        }
        return new_id;
    }
}
