N = int(input())  # 배열 개수

if N == 0:
    print(0)
else:
    meetings = []
    for i in range(N):
        start, end = map(int, input().split())
        meetings.append((start, end))

    # 끝나는 시간을 기준으로 정렬하고, 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
    meetings.sort(key=lambda x: (x[1], x[0]))

    count = 1
    last_end_time = meetings[0][1]

    for i in range(1, N):
        if meetings[i][0] >= last_end_time:
            count += 1
            last_end_time = meetings[i][1]

    print(count)
