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
        int[][] longest = new int[doc1.length()][doc2.length()];
        int up;
        int left;
        // Tabulation approach
        for (int i = 0; i < doc1.length(); i++){
            for (int j = 0; j < doc2.length(); j++) {
                up = 0;
                left = 0;
                // Find max of existing saved values in table — look up & left
                if (i - 1 >= 0) {
                    up = longest[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = longest[i][j - 1];
                }
                longest[i][j] = Math.max(left, up);
                // If the two most recent chars are equal, increment value by 1
                // Don't increment if it's impossible to have a substring that long
                if (doc1.charAt(i) == (doc2.charAt(j)) && (longest[i][j] <= i && longest[i][j] <= j)){
                    longest[i][j] += 1;
                }
            }
        }
        return longest[doc1.length() - 1][doc2.length() - 1];
    }
}