public class TargetedAd {
  public static void main(String[] args)
  {
    // create DataCollector object and set data
    DataCollector data = new DataCollector();
    data.setData("socialMediaPosts.txt", "targetWords.txt");
    // create a String to hold the users that will receive the ad
    String users = "";
    // loop through the posts and target words to find the users that will receive the ad
    String post = data.getNextPost();
    while (!post.equals("NONE")) {
      // word before space is username -> find username by finding space and then using substring to get the username
      int findSpace = post.indexOf(" ");  
      String findUser = post.substring(0, findSpace);
      // check if post contains any of the target words, if it does then add the user to the users string
      boolean target = false;
      String targetWord = data.getNextTargetWord();
      while (!targetWord.equals("NONE")) {
        //check if targetWord exists in post
        if (post.indexOf(targetWord) != -1) {
          target = true;
        }
        targetWord = data.getNextTargetWord();
      }
      // if theres a matched word then the username will get added to the users string
      if (target) {
        users += findUser + " ";
      }
      // move to next post & repeat till end
      post = data.getNextPost();
    } 
    // prepping advertisement file where users will be displayed along w/the advertisment
    data.prepareAdvertisement("iguanaAd.txt", users, "Buy our iguana food! It is the best on the market!");
  }
}
