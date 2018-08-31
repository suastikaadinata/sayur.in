package com.example.aryasa.drawersayur.ServerAPI;

public class Server {
    //untuk emu genymotion menggunakan ip = http://10.0.3.2/
    //untuk emu avd android menggunakan ip = http://10.0.2.2/
    //untuk langsung coba dihandphone menggunakan jaringan yang sama dan liat ipnya contoh http://192.168.1.14/
    public static final String URL = "http://10.0.2.2/api/";
    public static final String URLIMAGE = "http://10.0.2.2/img/";
<<<<<<< HEAD
    public static final String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImIxY2FkYTBhNjM" +
            "2ZmMyOTdlNzlhNGU2Y2QwZTI4YmIyNTg4NzM1ZGZiOTJlNTcxZjc5MThmYzVlNGQyNGJkNWY4ZWIwYjZlNzE3MTA2ZGRhIn" +
            "0.eyJhdWQiOiI1IiwianRpIjoiYjFjYWRhMGE2MzZmYzI5N2U3OWE0ZTZjZDBlMjhiYjI1ODg3MzVkZmI5MmU1NzFmNzk" +
            "xOGZjNWU0ZDI0YmQ1ZjhlYjBiNmU3MTcxMDZkZGEiLCJpYXQiOjE1MzU2OTYzODQsIm5iZiI6MTUzNTY5NjM4NCwiZXhw" +
            "IjoxNTY3MjMyMzg0LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.EWmbmSvG8kGzOEsMD5e11nEFcAoCEtzJI1NsnTiG7JpT" +
            "tbIGXrH-BmN6U0QV_qOY3Hj69_ZOtJRAv6pnRHatdajz3vMBwpuUlCejDolyp39Zm7yTbfnAIYlxnT8TUEJIwibZN3uJx" +
            "CuYevKJuB4enE0RF7-CSnQXuLUMOZBJwmH6AG57J7sCFxQ4at_AIFVUjuuKGElaJ0GDabc3JpYhzUFtCMWVy5apQBlh7w" +
            "GQZNsU6MLrmNZARzVR4ZJWQ6EN-gWc2p86ekIQs_-tFiSYEfFpXZEKEd_Xiu_PbflFjY9UqIyCCOwx2uiup2Y8e75WIzT6" +
            "Vzd-zKxSP9SJuRGjjVeYMl-6YEffPN-HVXnydO9Vw_4_H3XKoI40NiPzFxNLvkB7hJarlqk6SwRvaWD4kltc8PVDkmH5He" +
            "Tcgxd9aH15teE_fnTOEMH3Ds7_SoJqFaazjA-kUjo3sfi_4O9Sc5LvK7qhonSkm0GyVcsqiJkLVNBGWm8DUkZUKS2M305zv" +
            "Aj3wBnYOGJ37oPpxpbNZCVCUlnfW7xMBJGxRzqGbzdn9C3jQTrv8zrmt1E2zsPq4bj0Erp9TcEL7aA66Uv6KVdT4shG7wp_" +
            "MpZ5LxxLYJouTbK6A417G_YMaRpSA_H-9R1audvksz0L5KjvPF21J8Dx7CdtbObiR9CVhKdlhSc";
=======
    public static final String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1N" +
            "iIsImp0aSI6ImIxYmJjNTQ1M2QxOThkMjRjNGIzZmIyMTgwZTkzZDljNDE0MGY4ZDI4Ym" +
            "VmZDMxODNmNmIwNWZlOTg5NWM1Zjg0ODMxYzA0YWNjMDYwMzhmIn0.eyJhdWQiOiIxIiw" +
            "ianRpIjoiYjFiYmM1NDUzZDE5OGQyNGM0YjNmYjIxODBlOTNkOWM0MTQwZjhkMjhiZWZk" +
            "MzE4M2Y2YjA1ZmU5ODk1YzVmODQ4MzFjMDRhY2MwNjAzOGYiLCJpYXQiOjE1MzU2MTQ0Nz" +
            "UsIm5iZiI6MTUzNTYxNDQ3NSwiZXhwIjoxNTY3MTUwNDc0LCJzdWIiOiIxIiwic2NvcGVz" +
            "IjpbXX0.kgz6jh35h9KJsHEItuf0DLVCHw7Fsas7mKyqzWnYAzFzFoZI6hexNueOgzYj-z" +
            "Lt-uQsrGj8nUBHs1STVJfNhZ9xE1CXsVKne0KsY1-cFVQ3w_2N7xeCc06GFyujVODX1qgAl" +
            "VNKn3BSnkemCudSzAQbf90n6hJSTB1nUS2dEJOMbQ2QXY3faGUjiOGXgX6UuU0qYuPdaIcZ" +
            "JXG6_uB1r72r7WCV6_EB9jUbT5Sv51bGQ4veiXg8qzc7nlQrtuEYv8oU5Ppe3X76NAuPj_YQ" +
            "dI-fIDWaWDLR1Tb6cutzXAZYJMCWBX8tNtEmNj7vIZoYlAsBN1ea129qC582GDBtxP7szEqR" +
            "4SI7ZrfDRP7mPzESGdcKMoIcemOIoXBwdUgPbhiZ11S4lVUORlxesxgSjjpppX_OLxRc4qIZI" +
            "y4c_EYyZjvVMirQvVFOPorWHb3cn9cPqFb6OvJ3ZYaefbAIBJoPV1Zw2PdYlscOm2l8b590Hs" +
            "IsUbh6Mam42EnMxUZAXaaDIoQ5tDHwMYzQbibbvqqhZbR7VQXyefrgWxKM9wOh-AMzdQ5Dco6" +
            "QCsi5V-JLIniNZwBSz9ApdYMiRGVH32VD3Hx9gStbnOfuuRNL22MtQbSlVYAkAVdvheiCmB5Z0" +
            "v2sJN41XEq62rGgWqldGU0s9cdQcFzt089fnuGAtHg";
>>>>>>> master
}
