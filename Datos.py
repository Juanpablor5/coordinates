def preguntas():
    temp_result = []

    with open("data/2004-2018.json", encoding='utf-8') as json_file:
        data = json.load(json_file)
        for i in data["respuestas"]:
            if type(i["nombre"])==str:
                temp_result.append(i["nombre"])

    result = list(dict.fromkeys(temp_result))

    with open("temp_results/2004-2018.json", "w", encoding='utf-8') as file:
        json_dump = json.dumps(
            result, indent=3, sort_keys=False, ensure_ascii=False).encode("utf-8")
        file.write(json_dump.decode())


preguntas()