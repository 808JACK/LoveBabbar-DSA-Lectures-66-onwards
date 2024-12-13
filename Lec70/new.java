import streamlit as st
import pickle
import pandas as pd
import requests


def fetch_poster(movie_id):
    response = requests.get(
        'https://api.themoviedb.org/3/movie/{}?api_key=d48d5c2daa45975af11297171f660e1c'.format(movie_id))
    data = response.json()
    return "https://image.tmdb.org/t/p/w500/" + data['poster_path']


def recommend(movie):
    movie_index = movies[movies['title'] == movie].index[0]
    distances = similarity[movie_index]
    movies_list = sorted(list(enumerate(distances)), reverse=True, key=lambda x: x[1])[1:6]

    recommended_movies = []
    recommended_movies_posters = []

    for i in movies_list:
        movie_id = movies.iloc[i[0]].movie_id
        recommended_movies.append(movies.iloc[i[0]].title)
        recommended_movies_posters.append(fetch_poster(movie_id))

    return recommended_movies, recommended_movies_posters


# movies_dict = pickle.load(open('movies(1).pkl', 'rb'))
# movies = pd.DataFrame(movies_dict)

movies_dict = pickle.load(open('movies_dict(1).pkl', 'rb'))
movies = pd.DataFrame(movies_dict)


similarity = pickle.load(open('similarity(1).pkl', 'rb'))

st.title('🎬 Movie Recommender System ')

selected_movie_name = st.selectbox(
    'Select a movie:',
    movies['title'].values
)

if st.button('Recommend'):
    with st.spinner('Fetching recommendations...'):
        recommended_movie_names, recommended_movie_posters = recommend(selected_movie_name)

        col1, col2, col3, col4, col5 = st.columns(5)
        with col1:
            st.text(recommended_movie_names[0])
            st.image(recommended_movie_posters[0], use_column_width=True)
        with col2:
            st.text(recommended_movie_names[1])
            st.image(recommended_movie_posters[1], use_column_width=True)
        with col3:
            st.text(recommended_movie_names[2])
            st.image(recommended_movie_posters[2], use_column_width=True)
        with col4:
            st.text(recommended_movie_names[3])
            st.image(recommended_movie_posters[3], use_column_width=True)
        with col5:
            st.text(recommended_movie_names[4])
            st.image(recommended_movie_posters[4], use_column_width=True)
