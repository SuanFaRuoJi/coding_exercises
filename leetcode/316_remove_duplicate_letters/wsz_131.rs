pub mod remove_duplicate_letters_131 {
	use std::collections::HashMap;
	pub fn remove_duplicate_letters(s: String) -> String {
    	let mut answer = String::new();
		let mut appearrance = HashMap::new();
		let mut used = HashMap::new();
		for c in s.chars() {
			appearrance.entry(c).or_insert(0);
			appearrance.entry(c).and_modify(|num| {*num += 1});
		}
		// for (c, num) in &appearrance {
		// 	 println!("{}: {}", c, num);
		// }
		for c in s.chars() {
			appearrance.entry(c).and_modify(|num| {*num -= 1});
			if used.contains_key(&c) {
				continue
			}
			let mut top_char = get_last(&answer);
			while answer.len() != 0 &&
				hm_get(&appearrance, &top_char) != 0 &&
				comp(answer.chars().last(), Some(c))
			{
				used.remove(&top_char);
				answer.pop();
				top_char = get_last(&answer);
			}
			answer.push(c);
			used.insert(c, 0);
			// println!("{}", answer);
		}
		return answer;
    }

	fn hm_get(map: &HashMap<char, i32>, key: &char) -> i32 {
		match map.get(key) {
			None => -1,
			Some(num) => *num
		}
	}

	fn get_last(word: &String) -> char {
		match word.chars().last() {
			None => '\0',
			Some(c) => c
		}
	}

	fn comp(a: Option<char>, b: Option<char>) -> bool { // a >= b ?
		match b {
			None => false,
			Some(_b) => match a {
				None => true,
				Some(_a) => _a >= _b
			}
		}
	}
}