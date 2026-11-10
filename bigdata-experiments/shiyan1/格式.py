while True:
    search_input = input("Please enter text to search, separated by space: ").strip()
    if search_input.lower() == "exit":
        print("Goodbye!")
        break
    if not search_input:
        print("Error: Search text cannot be empty. Please try again.\n")
        continue
    valid_kws = []
    for kw in search_input.split():
        nw = normalize(kw)
        if len(nw) >= MIN_WORD_LENGTH and nw not in STOP_WORDS:
            valid_kws.append(nw)
    if not valid_kws:
        print("Error: No valid search terms (all are stop words or too short).\n")
        continue
    top_k = 10
    while True:
        k_input = input("Please enter the number of documents you want: ").strip()
        try:
            num = int(k_input)
            if num > 0:
                top_k = num
            break
        except ValueError:
            print("Error: Please enter a valid positive integer.")
    results = search_documents(global_index, valid_kws, top_k)
    print("\nSearch results:")
    if not results:
        print("No documents found containing all search terms.\n")
        continue
    for i, (fname, cnt, total) in enumerate(results, 1):
        print(f"{i}. {fname}")
        parts = [f"{k}({v})" for k, v in cnt.items()]
        print(f"   keyword count: {' | '.join(parts)} | total: {total}\n")

    if not os.path.isdir(args.file_dir):
        print(f"Error: Directory '{args.file_dir}' does not exist.")
        sys.exit(1)

    if not txt_paths:
        print(f"Error: No .txt files found in directory '{args.file_dir}'.")
        sys.exit(1)












if not os.path.isdir(args.file_dir):
    print(f"Error: Directory '{args.file_dir}' does not exist.")
    sys.exit(1)

if not txt_paths:
    print(f"Error: No .txt files found in directory '{args.file_dir}'.")
    sys.exit(1)









