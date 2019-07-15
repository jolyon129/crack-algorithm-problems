package edu.nyu.jolyon;

public class PlayWithGenerics {
    public class Echo<T> {
        public T echo(T value) {
            return value;
        }

        public Echo<T> echo(Echo<T> tEcho) {
            return tEcho;
        }


        public Echo() {
            return;
        }
    }
}
