package ParseURL;


public class ParseURL {

    public class URLExeption extends Exception
    {
        public URLExeption (String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "URL: " + super.getMessage();
        }
    }

    public void parse(String url) throws URLExeption
    {
        int num_equals = 0;

        String delims = "&";
        String[] tokens = url.split(delims);

        for(int i = 0; i < tokens.length; i++) {

            for (int j = 0; j < tokens[i].length(); j++) {
                if ('=' == tokens[i].charAt(j))
                    ++num_equals;
            }

            if( 1 < num_equals || 0 == num_equals )
                throw new URLExeption("wrong params");

            num_equals = 0;
        }

        System.out.println("Parse OK");

    }

}
