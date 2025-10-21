class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String start = "0000";
        int steps = 0;

        //early termination
        if (dead.contains(start)) {
            return -1;
        }

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return steps;
                }

                char[] charLock = current.toCharArray();

                for (int j = 0; j < 4; j++) {
                    char old = charLock[j];

                    //Turn up

                    if (charLock[j] == '9') {
                        charLock[j] = '0';
                    } else {
                        charLock[j] = (char) (charLock[j] + 1);
                    }

                    String next = String.valueOf(charLock);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }

                    charLock[j] = old;

                    //Turn Down

                    if (charLock[j] == '0') {
                        charLock[j] = '9';
                    } else {
                        charLock[j] = (char) (charLock[j] - 1);
                    }

                    next = String.valueOf(charLock);

                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }

                    charLock[j] = old;

                }

            }
            steps++;
        }
        return -1;

    }
}