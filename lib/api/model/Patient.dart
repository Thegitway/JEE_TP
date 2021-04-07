class Patient {
  int id;
  String nom;
  DateTime date;
  double score;
  bool sick;

  Patient({this.id, this.nom, this.date, this.score, this.sick});

  static Patient fromJson(Map<String, dynamic> json) {
    return Patient(
        id: json["id"] as int,
        nom: json["nom"] as String,
        date: json['date'] != null
            ? DateTime.parse(json['date'] as String)
            : null,
        score: json["score"] as double,
        sick: json["sick"] as bool);
  }
}
