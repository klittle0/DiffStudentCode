/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author KATE LITTLE
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        int[][] longest = new int[doc1.length() + 1][doc2.length() + 1];
        int up;
        int left;
        // Tabulation approach
        for (int i = 1; i <= doc1.length(); i++){
            for (int j = 1; j <= doc2.length(); j++) {
                // If the two current chars (current index) are equal, increment diagonal value by 1
                if (doc1.charAt(i - 1) == (doc2.charAt(j - 1))){
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                }
                // Otherwise, find max of values up & to the left
                else{
                    up = longest[i - 1][j];
                    left = longest[i][j - 1];
                    longest[i][j] = Math.max(left, up);
                }
            }
        }
        return longest[doc1.length()][doc2.length()];
    }
}