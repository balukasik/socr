import requests

class Api_handler:


    def __init__(self, username):
        self.verify_username(username)
        self.username = username
        self.repos = self.get_repos_dict()

    def verify_username(self, username):
        req = requests.get(f"https://api.github.com/users/{username}")
        if req.status_code >= 400:
            raise Exception(req.json()["message"])
        
         
    def get_repos_dict(self):
        flag = True
        page = 1
        repos_list = []
        while (flag):
            query_url = f"https://api.github.com/users/{self.username}/repos?per_page=100&page={page}"
            repos = requests.get(query_url).json()
            if len(repos) == 0:
                flag = False
            repos_list += repos
            page += 1
        return repos_list


    def get_list(self):
        repos_list = []
        for repo in self.repos:
            repos_list.append({"name": repo["name"], "stargazers_count": repo["stargazers_count"]})
        return repos_list

    def get_starsum(self):
        return [{"starsum" : sum(repo["stargazers_count"] for repo in self.repos)}]