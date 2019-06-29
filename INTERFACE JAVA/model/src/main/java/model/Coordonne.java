package model;

public class Coordonne {
    private int[] A = {245,365};
    private int[] B = {155,365};
    private int[] C = {155,440};
    private int[] D = {245,440};
    private int[] E = {455,440};
    private int[] F = {455,365};
    private int[] G = {535,365};
    private int[] H = {595,365};
    private int[] I = {595,540};
    private int[] J = {535,540};
    private int[] K = {155,540};
    private int[] L = {535,590};
    private int[] M = {245,590};
    private int[] N = {155,655};
    private int[] O = {245,655};
    private int[] P = {595,655};
    public int x;
    public int y;

    public Coordonne(String actuel) {
        switch (actuel) {
            case "A":
                this.x = A[0];
                this.y = A[1];
                break;
            case "B":
                this.x = B[0];
                this.y = B[1];
                break;
            case "C":
                this.x = C[0];
                this.y = C[1];
                break;
            case "D":
                this.x = D[0];
                this.y = D[1];
                break;
            case "E":
                this.x = E[0];
                this.y = E[1];
                break;
            case "F":
                this.x = F[0];
                this.y = F[1];
                break;
            case "G":
                this.x = G[0];
                this.y = G[1];
                break;
            case "H":
                this.x = H[0];
                this.y = H[1];
                break;
            case "I":
                this.x = I[0];
                this.y = I[1];
                break;
            case "J":
                this.x = J[0];
                this.y = J[1];
                break;
            case "K":
                this.x = K[0];
                this.y = K[1];
                break;
            case "L":
                this.x = L[0];
                this.y = L[1];
                break;
            case "M":
                this.x = M[0];
                this.y = M[1];
                break;
            case "N":
                this.x = N[0];
                this.y = N[1];
                break;
            case "O":
                this.x = O[0];
                this.y = O[1];
                break;
            case "P":
                this.x = P[0];
                this.y = P[1];
                break;
            default:
                this.x = 0;
                this.y = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
