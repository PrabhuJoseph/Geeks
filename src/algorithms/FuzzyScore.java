package algorithms;

public class FuzzyScore {


    public static Integer fuzzyScore(final CharSequence term, final CharSequence query) {
        if (term == null || query == null) {
            throw new IllegalArgumentException("CharSequences must not be null");
        }

        final String termLowerCase = term.toString().toLowerCase();
        final String queryLowerCase = query.toString().toLowerCase();


        int score = 0;
        int termIndex = 0;
        int previousMatchingCharacterIndex = Integer.MIN_VALUE;

        for (int queryIndex = 0; queryIndex < queryLowerCase.length(); queryIndex++) {
            final char queryChar = queryLowerCase.charAt(queryIndex);

            boolean termCharacterMatchFound = false;
            for (; termIndex < termLowerCase.length()
                    && !termCharacterMatchFound; termIndex++) {
                final char termChar = termLowerCase.charAt(termIndex);

                if (queryChar == termChar) {
                    score++;

                    if (previousMatchingCharacterIndex + 1 == termIndex) {
                        score += 2;
                    }

                    previousMatchingCharacterIndex = termIndex;
                    termCharacterMatchFound = true;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
      System.out.println(fuzzyScore("Apache Software Foundation","asf"));
    }

}