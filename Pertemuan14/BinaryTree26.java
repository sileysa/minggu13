public class BinaryTree26 {
    Node26 root;

    public BinaryTree26() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa26 mahasiswa) {
        Node26 newNode = new Node26(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node26 current = root;
            Node26 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(double ipk) {
        boolean result = false;
        Node26 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    public void traversePreOrder(Node26 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node26 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node26 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    public Node26 getSuccessor(Node26 del) {
        Node26 successor = del.right;
        Node26 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }
        //cari node (current) yang akan dihapus
        Node26 parent = root;
        Node26 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        //penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            //jika tidak ada anak (leaf) , maka node dihapus
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {//jika hanya punya 1 anak (kanan)
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) {//jika hanya punya 1 anak (kiri)
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {//jika punya 2 anak
                Node26 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }

    public Node26 tambahRekursif(Node26 current, Node26 newNode) {
        if (current == null) {
            return newNode; // posisi ditemukan, letakkan node baru di sini
        }

        if (newNode.mahasiswa.ipk < current.mahasiswa.ipk) {
            current.left = tambahRekursif(current.left, newNode);
        } else {
            current.right = tambahRekursif(current.right, newNode);
        }

        return current; // kembalikan current agar rekursi bisa menyusun ulang tree dengan benar
    }

    public Mahasiswa26 cariMinIPK() {
        if (root == null) {
            System.out.println("Tree kosong");
            return null;
        }

        Node26 current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.mahasiswa;
    }

    public Mahasiswa26 cariMaxIPK() {
        if (root == null) {
            System.out.println("Tree kosong");
            return null;
        }

        Node26 current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.mahasiswa;
    }

    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        tampilMahasiswaIPKdiAtasRekursif(root, ipkBatas);
    }

    private void tampilMahasiswaIPKdiAtasRekursif(Node26 node, double ipkBatas) {
        if (node != null) {
            // Karena BST, jika node.ipk > batas, maka kemungkinan juga anak kiri punya data valid
            tampilMahasiswaIPKdiAtasRekursif(node.left, ipkBatas);
            
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }

            // Tetap telusuri anak kanan karena bisa saja banyak ipk di atas batas
            tampilMahasiswaIPKdiAtasRekursif(node.right, ipkBatas);
        }
    }

}
