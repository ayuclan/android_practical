@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText edtunm = findViewById(R.id.editTextText);
    EditText edtpwd = findViewById(R.id.editTextText2);
    Button btnSave = findViewById(R.id.button2);
    Button btnDisplay = findViewById(R.id.button);

    SQLiteDatabase mydatabase = openOrCreateDatabase("db", MODE_PRIVATE, null);
    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TutorialsPoint(Username VARCHAR,Password VARCHAR);");

    btnDisplay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        }
    });

    btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Add Code
            String unm = edtunm.getText().toString();
            String pwd = edtpwd.getText().toString();
            mydatabase.execSQL("INSERT INTO TutorialsPoint VALUES('"+unm+"','"+pwd+"');");
        }
    });
}
